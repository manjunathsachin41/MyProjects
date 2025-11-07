package com.example.Commerce.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Commerce.Service.UrlShortenService;

@RestController
public class UrlShortenController {

	private static final Logger logger = LoggerFactory.getLogger(UrlShortenController.class);

	@Autowired
	UrlShortenService urlShortenService;

	// http://localhost:8080/shortUrl?longUrl=system-designrate-limiting-algorithms-system-design
	@GetMapping("/shortUrl")
	public ResponseEntity<String> getShortUrl(@RequestParam String longUrl) {
		logger.info("Inside Controller: " + longUrl);
		String shortUrl = urlShortenService.getShortUrl(longUrl);
		return new ResponseEntity<String>("Url Shortened: " + shortUrl, HttpStatus.CREATED);
	}

}
