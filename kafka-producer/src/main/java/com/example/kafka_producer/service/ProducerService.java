package com.example.kafka_producer.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.example.kafka_producer.model.Customer;

@Service
public class ProducerService {

	private static final String CUSTOMER_TOPIC = "customerTopic";

	private static final String PAYMENT_TOPIC = "paymentTopic";

	private static final String TEST_TOPIC = "testTopic";

	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;

	@Autowired
	private KafkaTemplate<String, String> testTemplate;

	public String sendCustomerObject(Customer customer) {
		kafkaTemplate.send(CUSTOMER_TOPIC, "mycust", customer);
		return "Customer added to topic";
	}

	public String sendMessageToRandomPartition(String message) {
		// When key is not passed as argument, the messages randomly goes
		// to different partition and randomly consumed by consumer.
		CompletableFuture<SendResult<String, String>> future = testTemplate.send(TEST_TOPIC, message);
		future.whenComplete((result, ex) -> {
			if (ex == null) {
				// Message sent successfully
			} else {
				// Thr is an exception
			}
		});
		return "Message added to test topic";

	}

	public void sendMessageToParticularPartition() {
		// Sending all message To paymentTopic and particular partition only.
		testTemplate.send(PAYMENT_TOPIC, 0, null, "Hai");
		testTemplate.send(PAYMENT_TOPIC, 1, null, "Hello");
		testTemplate.send(PAYMENT_TOPIC, 2, null, "Welcome to");
		testTemplate.send(PAYMENT_TOPIC, 2, null, "Youtube");

	}

}
