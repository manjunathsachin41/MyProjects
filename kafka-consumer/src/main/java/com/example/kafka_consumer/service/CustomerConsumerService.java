package com.example.kafka_consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.example.kafka_producer.model.Customer;

@Service
public class CustomerConsumerService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerConsumerService.class);

	@KafkaListener(topics = "customerTopic", groupId = "consumer_grp1")
	public void consumeCustomer(Customer customer) {
		logger.info("Message Consumed : " + customer.getCustId());
	}
	
}
