package com.javatechie.controller;

import com.javatechie.dto.AuthRequest;
import com.javatechie.entity.UserCredential;
import com.javatechie.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthService service;

	@Autowired
	private AuthenticationManager authenticationManager;

	/*
	 * { "name": "Manju", "email": "a@gmail.com", "password": "man12" }
	 * http://localhost:8081/auth/register
	 */
	@PostMapping("/register")
	public String signUp(@RequestBody UserCredential user) {
		return service.saveUser(user);
	}
	
	
	/*
	 * http://localhost:8081/auth/token
	 * { "username": "Manju", "password": "man12" }
	 */
	@PostMapping("/token")
	public String loginAndGetToken(@RequestBody AuthRequest authRequest) {
		// The task of checking whether this user exist in our r not is delegated
		//to authenticationManager.
		// Only if user is prviously registered, it generate and provide token.
		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if (authenticate.isAuthenticated()) {
			return service.generateToken(authRequest.getUsername());
		} else {
			throw new RuntimeException("invalid access");
		}
	}

	@GetMapping("/validate")
	public String validateToken(@RequestParam("token") String token) {
		service.validateToken(token);
		return "Token is valid";
	}
}
