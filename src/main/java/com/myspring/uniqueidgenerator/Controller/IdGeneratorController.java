package com.myspring.uniqueidgenerator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspring.uniqueidgenerator.Algorithm.DatabaseSequence;
import com.myspring.uniqueidgenerator.Algorithm.SnowflakeIdGenerator;
import com.myspring.uniqueidgenerator.Algorithm.TimestampRandom;
import com.myspring.uniqueidgenerator.Algorithm.UUIDGenerator;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class IdGeneratorController {
	
	private final DatabaseSequence databaseSequece;
	private final TimestampRandom timestampRandom;
	private final SnowflakeIdGenerator snowflakeIdGenerator;
	private final UUIDGenerator uuidGenerat;
	
	
	
	@GetMapping("/timestamp+random")
	public String getGenerateId() {
		return timestampRandom.generateUniqueId();
	}
	
	@GetMapping("/builtIn-UUID")
	public String getGenerateUUId() {
		return uuidGenerat.generateUUID();
	}
	
	@GetMapping("/snowflakeIdGenerator")
	public String getSnowflakeIdGenerator() {
		return  snowflakeIdGenerator.generateUniqueId();
	}
	
	@GetMapping("/databaseSequece")
	public String getDatabaseSequece() {
		return  databaseSequece.generateDatabaseSequenceId();
	}

}
