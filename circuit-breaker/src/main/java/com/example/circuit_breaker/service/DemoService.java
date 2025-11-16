package com.example.circuit_breaker.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.circuit_breaker.feign.FeignShortenUrl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class DemoService {

	private static final Logger logger = LoggerFactory.getLogger(DemoService.class);

	@Autowired
	FeignShortenUrl feignShortenUrl;

	@Autowired
	RestTemplate restTemplate;

	private int attemp = 1;

	/*
	 * When service is down, the circuit status will change from closed to open.
	 * After given seconds and when new request comes, circuit status will change from open to Half_open.
	 */
	
	@CircuitBreaker(name = "testCircuitBreaker", fallbackMethod = "createUrlFallBack")
	public ResponseEntity<String> testCircuitBreakerService(String name) {
		ResponseEntity<String> message = feignShortenUrl.checkCircuit(name);
		return new ResponseEntity<String>(message.getBody(), HttpStatus.OK);
	}

	public ResponseEntity<String> createUrlFallBack(String name, Exception ex) {
		return new ResponseEntity<String>("Fallback is called", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*
	 * When the service is down, it tries to reconnect to service for every given second in config.
	 * Once maximum retry is reached, it calls fallback method.
	 */
	@Retry(name = "testRetryService", fallbackMethod = "testFallBack")
	public String testRetryService() {
		logger.info("Retry attemp: " + attemp++);
		String apiUrl = "http://localhost:8082/url/checkRetry"; // Example API
		String msg = restTemplate.getForObject(apiUrl, String.class);
		return msg;
	}

	public String testFallBack(Exception e) {
		return "Fallback for Retry";
	}

}
