package com.example.circuit_breaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.circuit_breaker.service.DemoService;

@RestController
public class DemoController {
	
	@Autowired
	DemoService demoService;
	
	//http://localhost:8081/testCircuit?name=manju
	//http://localhost:8081/actuator/health
	@GetMapping("/testCircuit")
	public ResponseEntity<String> checkCircuitBreaker(@RequestParam String name) {
		ResponseEntity<String> shortUrl = demoService.testCircuitBreakerService(name);
		return new ResponseEntity<String>(shortUrl.getBody(), HttpStatus.OK);
	}
	
	//http://localhost:8081/testRetry
	@GetMapping("/testRetry")
	public String testRetry() {
		String shortUrl = demoService.testRetryService();
		return shortUrl;
	}

}
