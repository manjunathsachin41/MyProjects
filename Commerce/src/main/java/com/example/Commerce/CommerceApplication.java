package com.example.Commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class CommerceApplication {

	public static void main(String[] args) {
		//run() method starts the application's embedded web server.
		SpringApplication.run(CommerceApplication.class, args);
	}

}
