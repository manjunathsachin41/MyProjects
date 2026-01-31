package com.example.kafka_producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.kafka_producer.model.Customer;
import com.example.kafka_producer.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/kafka")
public class ProducerController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);
	
	@Autowired
	private ProducerService producerService;
	
	// http://localhost:8081/kafka/addCustomer
	/* {
		  "custId": "100",
		  "custName": "Dexter",
		  "custAddress": "US",
		  "phNumber": 995379
		 } */
	@PostMapping("/addCustomer")
	public ResponseEntity<String> sendCustomerObject(@RequestBody Customer customer) {
		String response = producerService.sendCustomerObject(customer);
		logger.info("Message sent : " + customer.getCustId());
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	// http://localhost:8081/kafka/random
	@GetMapping("/random")
	public void sendMessageToRandomPartition() {
		for (int i = 0; i < 10000; i++) {
			producerService.sendMessageToRandomPartition("Manju: " + i);
			logger.info("Message sent : " + "Manju" + i);
		}
	}
	
	// http://localhost:8081/kafka/particular
	@GetMapping("/particular")
	public void sendMessageToParticularPartition() {
		producerService.sendMessageToParticularPartition();
		logger.info("Message sent to particular Partitions ");
	}

}
