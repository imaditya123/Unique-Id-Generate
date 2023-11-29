package com.myspring.uniqueidgenerator.Algorithm;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UUIDGenerator {
	
	public  String generateUUID() {
        return UUID.randomUUID().toString();
    }

}
