package com.example.circuit_breaker.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "URLSHORTENING")
public interface FeignShortenUrl {
	
	@PostMapping("/url/shorten")
	public ResponseEntity<String> shortenUrl(@RequestParam(required = false) String longUrl);
	
	@GetMapping("/url/checkRetry")
	public String checkRetry();
	
	@GetMapping("/url/checkCircuit")
	public ResponseEntity<String> checkCircuit(String name);

}
