package com.example.urlshortening.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import com.example.urlshortening.service.UrlService;

@RestController
public class UrlController {

	private static final Logger logger = LoggerFactory.getLogger(UrlController.class);

	@Autowired
	private UrlService urlService;

	@Autowired
	private Environment environment;

	@PostMapping("/shorten")
	public ResponseEntity<String> shortenUrl(@RequestParam(required = false) String longUrl) {
		logger.info("Inside shortenUrl of " + longUrl);
		logger.info("Port number : " + environment.getProperty("local.server.port"));
		String shortUrl = urlService.shortenUrl(longUrl);
		return new ResponseEntity<>(shortUrl, HttpStatus.OK);
	}

	@GetMapping("/s/{shortCode}")
	public RedirectView redirect(@PathVariable String shortCode) {
		String longUrl = urlService.getLongUrl(shortCode);
		if (longUrl != null) {
			return new RedirectView(longUrl);
		} else {
			// Handle not found case, e.g., redirect to an error page
			return new RedirectView("/error");
		}
	}
}
