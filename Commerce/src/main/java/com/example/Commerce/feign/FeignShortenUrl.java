package com.example.Commerce.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 Reduced Boilerplate Code: It significantly reduces the amount of boilerplate code required 
 for making HTTP calls, handling connections, and parsing responses, compared to manually 
 using clients like RestTemplate.

 */

@FeignClient(name = "URLSHORTENING")
public interface FeignShortenUrl {

	@PostMapping("/shorten")
	public ResponseEntity<String> shortenUrl(@RequestParam(required = false) String longUrl);
	// This method signature must be same as method Urlshortening controller.

}
