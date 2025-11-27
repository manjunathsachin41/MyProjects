package com.example.urlshortening.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.view.RedirectView;

import com.example.urlshortening.service.UrlService;

public class UrlControllerTest {
	
	/*
	 * @InjectMocks : It is the class to be tested. It works by first creating a real instance of the class being tested and 
	 * then looking for dependencies to fill in using mocks.
	 */

	@InjectMocks
	UrlController urlController;

	//The dependency to be mocked.
	@Mock
	private UrlService urlService;

	@Mock
	private Environment environment;
	
	String longUrl = "http://espncricinfo.com/sachin_tendulkar";
	
	String shortUrl = "http://localhost:8080/OTU3Nj";
	
	private static final String SHORT_CODE = "OTU3Nj";

	@BeforeEach
	public void setUp() {
		//Enabling Mockito Annotations
		MockitoAnnotations.openMocks(this); // Initialize mocks and inject them
	}
	
	@Test
	public void testShortenUrl() {
		when(urlService.shortenUrl(longUrl)).thenReturn(shortUrl);
		ResponseEntity<String> result = urlController.shortenUrl(longUrl);
		assertEquals(result.getBody(), shortUrl);
		assertEquals(result.getStatusCode(), HttpStatus.OK);
		verify(urlService,times(1)).shortenUrl(longUrl);
	}
	
	@Test
	public void testRedirect() {
		when(urlService.getLongUrl(SHORT_CODE)).thenReturn(longUrl);
		RedirectView result = urlController.redirect(SHORT_CODE);
		assertEquals(result.getUrl(), longUrl);
	}
	
	/*
	 * @Spy annotation is used to create a real object and spy on that real object. 
	 * A spy helps to call all the normal methods of the object while still tracking every interaction, just as we would with a mock.
	 * @Spy: Both real and mocked behavior.
	 * Executes real methods unless explicitly mocked.
	 */

}
