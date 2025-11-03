package com.example.urlshortening.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.urlshortening.model.Url;
import com.example.urlshortening.repository.UrlRepository;

import java.util.Base64;
import java.util.Optional;

@Service
public class UrlService {

	@Autowired
	private UrlRepository urlRepository;

	private final String BASE_URL = "http://localhost:8080/"; // Replace with your domain

	public String shortenUrl(String longUrl) {
		// Check if long URL already exists to avoid duplicate short URLs
		Url existingUrl = urlRepository.findByLongUrl(longUrl);
		if (existingUrl != null) {
			return existingUrl.getShortUrl();
		}

		String shortCode = generateShortCode(longUrl);
		Url newUrl = new Url(longUrl, BASE_URL + shortCode);
		urlRepository.save(newUrl);
		return newUrl.getShortUrl();
	}

	public String getLongUrl(String shortCode) {
		Url url = urlRepository.findByShortUrl(BASE_URL + shortCode);
		return (url != null) ? url.getLongUrl() : null;
	}

	private String generateShortCode(String longUrl) {
		// A simple way to generate a short code (e.g., using Base64 encoding of a hash)
		// In a real-world scenario, consider a more robust and collision-resistant
		// approach
		String hash = String.valueOf(longUrl.hashCode());
		return Base64.getUrlEncoder().withoutPadding().encodeToString(hash.getBytes()).substring(0, 6);
	}
}
