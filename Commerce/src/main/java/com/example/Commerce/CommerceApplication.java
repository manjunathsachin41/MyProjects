package com.example.Commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
@EnableFeignClients
public class CommerceApplication {

	public static void main(String[] args) {
		//run() method starts the application's embedded web server.
		SpringApplication.run(CommerceApplication.class, args);
	}

}
