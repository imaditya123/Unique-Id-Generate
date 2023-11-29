package com.myspring.uniqueidgenerator.Algorithm;

import org.springframework.stereotype.Service;

@Service
public class SnowflakeIdGenerator {

	// The epoch (January 1, 1970 00:00:00 UTC) in milliseconds
	private static final long EPOCH = 1_580_000_000_000L;

	// Number of bits for each component
	private static final long TIMESTAMP_BITS = 41;
	private static final long MACHINE_ID_BITS = 10;
	private static final long SEQUENCE_BITS = 12;

	// Maximum values for each component
	private static final long MAX_MACHINE_ID = (1L << MACHINE_ID_BITS) - 1;
	private static final long MAX_SEQUENCE = (1L << SEQUENCE_BITS) - 1;

	// Shifts for each component
	private static final long TIMESTAMP_SHIFT = MACHINE_ID_BITS + SEQUENCE_BITS;
	private static final long MACHINE_ID_SHIFT = SEQUENCE_BITS;

	private final long machineId;
	private long lastTimestamp = -1L;
	private long sequence = 0L;

	public SnowflakeIdGenerator(long machineId) {
		if (machineId < 0 || machineId > MAX_MACHINE_ID) {
			throw new IllegalArgumentException("Machine ID must be between 0 and " + MAX_MACHINE_ID);
		}
		this.machineId = machineId;
	}

	public SnowflakeIdGenerator() {

		this.machineId = 0;
	}

	public String generateUniqueId() {
		long currentTimestamp = getCurrentTimestamp();

		if (currentTimestamp < lastTimestamp) {
			throw new IllegalStateException("Clock moved backwards. Refusing to generate ID.");
		}

		if (currentTimestamp == lastTimestamp) {
			sequence = (sequence + 1) & MAX_SEQUENCE;
			if (sequence == 0) {
				// Wait until the next millisecond
				currentTimestamp = waitNextMillis(currentTimestamp);
			}
		} else {
			sequence = 0L;
		}

		lastTimestamp = currentTimestamp;

		return String
				.valueOf(((currentTimestamp - EPOCH) << TIMESTAMP_SHIFT) | (machineId << MACHINE_ID_SHIFT) | sequence);
	}

	private long waitNextMillis(long currentTimestamp) {
		long timestamp = getCurrentTimestamp();
		while (timestamp <= currentTimestamp) {
			timestamp = getCurrentTimestamp();
		}
		return timestamp;
	}

	private long getCurrentTimestamp() {
		return System.currentTimeMillis();
	}

}
