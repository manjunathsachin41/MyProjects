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
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class DemoService {

	private static final Logger logger = LoggerFactory.getLogger(DemoService.class);

	@Autowired
	private FeignShortenUrl feignShortenUrl;

	@Autowired
	private RestTemplate restTemplate;

	private int circuitBreakAttempt = 1;
	
	private int retryAttempt = 1;
	
	private int rateLimiter = 1;

	/*
	 * When service is down, the circuit status will change from closed to open.
	 * After given seconds and when new request comes, circuit status will change from open to Half_open.
	 */
	@CircuitBreaker(name = "testCircuitBreaker", fallbackMethod = "createCircuitBreakerFallBack")
	public ResponseEntity<String> testCircuitBreakerService() {
		//String message = feignShortenUrl.checkCircuit(name);
		
		logger.info("CircuitBreaker attempt: " + circuitBreakAttempt++);
		String apiUrl = "http://localhost:8082/url/checkCircuit"; // Example API
		String msg = restTemplate.getForObject(apiUrl, String.class);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	public ResponseEntity<String> createCircuitBreakerFallBack(String name, Exception ex) {
		logger.info("Fallback for CircuitBreaker is called");
		return new ResponseEntity<String>("Fallback is called", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*
	 * When the service is down, it tries to reconnect to service for every given second in config.
	 * Once maximum retry is reached, it calls fallback method.
	 */
	@Retry(name = "testRetryService", fallbackMethod = "createRetryFallBack")
	public String testRetryService() {
		logger.info("Retry attempt: " + retryAttempt++);
		String apiUrl = "http://localhost:8082/url/checkRetry"; // Example API
		String msg = restTemplate.getForObject(apiUrl, String.class);
		return msg;
	}

	public String createRetryFallBack(Exception e) {
		logger.info("Fallback for Retry is called");
		return "Fallback for Retry";
	}

	@RateLimiter(name = "testRateLimiter", fallbackMethod = "createRateLimiterFallBack")
	public String testRateLimiterService() {
		logger.info("RateLimiter attempt: " + rateLimiter++);
		String apiUrl = "http://localhost:8082/url/checkRateLimiter"; // Example API
		String msg = restTemplate.getForObject(apiUrl, String.class);
		return msg;
	}
	
	public String createRateLimiterFallBack(Exception e) {
		logger.info("Fallback for RateLimiter is called");
		return "Fallback for RateLimiter";
	}

}
