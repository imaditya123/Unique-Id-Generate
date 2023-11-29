package com.myspring.uniqueidgenerator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspring.uniqueidgenerator.Service.IdGeneratorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class IdGeneratorController {
	
	private final IdGeneratorService service;
	
	@GetMapping("/generateId")
	public String getGenerateId() {
		return service.generateUniqueId();
	}
	
	@GetMapping("/generateUUID")
	public String getGenerateUUId() {
		return service.generateUUID();
	}

}
