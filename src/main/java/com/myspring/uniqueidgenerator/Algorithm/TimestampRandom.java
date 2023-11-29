package com.myspring.uniqueidgenerator.Algorithm
;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;



@Service
public class TimestampRandom {
	
	public  String generateUniqueId() {
        long timestamp = System.currentTimeMillis();
        int random = new Random().nextInt(1000); // Adjust the range based on your needs
        return String.valueOf(timestamp) + random;
    }

}
