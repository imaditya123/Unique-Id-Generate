package com.myspring.uniqueidgenerator.Algorithm;

import org.springframework.stereotype.Service;

@Service
public class DatabaseSequence {
	
	private  Long incrementer;
	
	
	public DatabaseSequence() {
		incrementer=0L;
	}
	
	public String generateDatabaseSequenceId() {
		
		return String.valueOf(incrementer++);
	}	

}
 