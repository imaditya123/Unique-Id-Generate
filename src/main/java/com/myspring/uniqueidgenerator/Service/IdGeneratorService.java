package com.myspring.uniqueidgenerator.Service;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;


@Service
public class IdGeneratorService {
	
	public  String generateUniqueId() {
        long timestamp = System.currentTimeMillis();
        int random = new Random().nextInt(1000); // Adjust the range based on your needs
        return String.valueOf(timestamp) + random;
    }

	
	public  String generateUUID() {
        return UUID.randomUUID().toString();
    }

	
	

}
