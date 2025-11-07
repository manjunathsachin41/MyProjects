package com.example.Commerce.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Commerce.feign.FeignShortenUrl;

@Service
public class UrlShortenService {
	
	private static final Logger logger = LoggerFactory.getLogger(UrlShortenService.class);
	
	@Autowired
	FeignShortenUrl feignShortenUrl;
	
	public String getShortUrl(String longUrl) {
		logger.info("Inside Service");
		ResponseEntity<String> shortUrl = feignShortenUrl.shortenUrl(longUrl);
		return shortUrl.getBody();
	}

}
