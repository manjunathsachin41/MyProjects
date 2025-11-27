package com.example.urlshortening.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.urlshortening.model.Url;
import com.example.urlshortening.repository.UrlRepository;

public class UrlServiceTest {

	@Mock
	private UrlRepository urlRepository;

	@InjectMocks
	private UrlService urlService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this); // Initialize mocks and inject them
	}

	@Test
	public void testConvertingLongUrlToShortUrl() {
		String shortUrl = urlService.shortenUrl("http://espncricinfo.com/sachin_tendulkar");
		System.out.println(shortUrl);
		assertEquals("http://localhost:8080/OTU3Nj", shortUrl);
	}

	@Test
	public void testAlreadyExistingShortUrlFromRepo() {
		// setUp
		String longUrl = "http://espncricinfo.com/sachin_tendulkar";
		String shortUrl = "http://localhost:8080/OTU3Nj";
		Url existingShortUrl = new Url(longUrl, shortUrl);
		when(urlRepository.findByLongUrl(longUrl)).thenReturn(existingShortUrl);

		String shortenedUrl = urlService.shortenUrl(longUrl);
		assertEquals("http://localhost:8080/OTU3Nj", shortenedUrl);
		verify(urlRepository, times(1)).findByLongUrl(longUrl);
	}

	@Test
	public void testGettingLongUrlFromRepo() {
		String longUrl = "http://espncricinfo.com/sachin_tendulkar";
		String shortUrl = "http://localhost:8080/OTU3Nj";
		Url existingLongUrl = new Url(longUrl, shortUrl);
		when(urlRepository.findByShortUrl(shortUrl)).thenReturn(existingLongUrl);

		String longUrlFromRepo = urlService.getLongUrl("OTU3Nj");
		assertEquals(longUrl, longUrlFromRepo);
		verify(urlRepository, times(1)).findByShortUrl(shortUrl);
	}

}
