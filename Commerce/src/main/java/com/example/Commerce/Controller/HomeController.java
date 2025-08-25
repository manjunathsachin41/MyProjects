package com.example.Commerce.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@ It signifies this as bean + rest service
@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String greetings() {
		System.out.println("I am here!!!");
		return "Welcome to Website";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "About the website";
	}


}
