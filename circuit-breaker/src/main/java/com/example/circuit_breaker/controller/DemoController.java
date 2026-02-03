package com.example.circuit_breaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.circuit_breaker.service.DemoService;

@RestController
public class DemoController {
	
	@Autowired
	private DemoService demoService;
	
	//http://localhost:8081/testCircuit
	//http://localhost:8081/actuator/health
	@GetMapping("/testCircuit")
	public ResponseEntity<String> checkCircuitBreaker() {
		ResponseEntity<String> message = demoService.testCircuitBreakerService();
		return new ResponseEntity<String>(message.getBody(), HttpStatus.OK);
	}
	
	//http://localhost:8081/testRetry
	@GetMapping("/testRetry")
	public String testRetry() {
		String message = demoService.testRetryService();
		return message;
	}
	
	//http://localhost:8081/testRateLimiter
	@GetMapping("/testRateLimiter")
	public String testRateLimiter() {
		String message = demoService.testRateLimiterService();
		return message;
	}

}
