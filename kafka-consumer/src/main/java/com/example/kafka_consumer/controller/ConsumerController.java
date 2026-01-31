package com.example.kafka_consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.kafka_consumer.service.MessageConsumerService;

@RestController
@RequestMapping("/kafka")
public class ConsumerController {
	
	@Autowired
	MessageConsumerService consumerService;
	
	private String response;
	
	// http://localhost:8082/kafka/getMsg
	@GetMapping("/getMsg")
	public ResponseEntity<String> getMessage() {
		response= consumerService.getMessage();
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}

}
