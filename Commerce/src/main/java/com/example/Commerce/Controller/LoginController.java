package com.example.Commerce.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource("classpath:mycustom.properties")
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Value("${custom.application.name}")
	private String customAppName;

	// http://localhost:8080/log
	@RequestMapping("/log")
	public String login() {
		return "Logged in Succesfully to " + customAppName;
	}

	// http://localhost:8080/login?username=admin&pwd=admin123 
	@GetMapping("/login")
	public String loginWithValue(@RequestParam("username") String user, @RequestParam("pwd") String pwd) {
		String message = "Username: " + user + " Password: " + pwd + " logged in Succesfully";
		LOGGER.info(message);
		return message;
	}

}
