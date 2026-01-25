package com.example.kafka_producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.kafka_producer.model.Course;
import com.example.kafka_producer.service.ProducerService;

@RestController
@RequestMapping("/kafka")
public class ProducerController {
	
	@Autowired
	ProducerService producerService;
	
	// http://localhost:8081/kafka/addMsg
	/* {
		  "courseId": "105",
		  "title": "Java",
		  "trainer": "John",
		  "price": 3000
		 } */
	@PostMapping("/addMsg")
	public ResponseEntity<String> addMessage(@RequestBody Course course) {
		
		String response = producerService.addMessage(course);
		return new ResponseEntity<String>(response, HttpStatus.OK);
		
	}

}
