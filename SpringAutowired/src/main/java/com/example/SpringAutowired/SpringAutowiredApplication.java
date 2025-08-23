package com.example.SpringAutowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringAutowiredApplication {

	public static void main(String[] args) {

		// It creates Spring Container for the project
		ApplicationContext ctx = SpringApplication.run(SpringAutowiredApplication.class, args);

		Developer dev = (Developer) ctx.getBean("developer");

		dev.callDev();
	}

}
