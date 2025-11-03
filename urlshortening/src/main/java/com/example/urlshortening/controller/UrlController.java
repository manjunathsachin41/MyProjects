package com.example.urlshortening.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import com.example.urlshortening.service.UrlService;

@RestController
public class UrlController {

	@Autowired
	private UrlService urlService;

	@PostMapping("/shorten")
	public ResponseEntity<String> shortenUrl(@RequestParam(required = false) String longUrl) {
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
