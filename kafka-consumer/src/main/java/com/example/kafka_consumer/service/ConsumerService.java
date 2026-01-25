package com.example.kafka_consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.example.kafka_producer.model.Course;

@Service
public class ConsumerService {

	@Autowired
	KafkaTemplate<String, Course> kafkaTemplate;

	private String message;

	// Automatically called when message is in topic.
	@KafkaListener(topics = "telusko", groupId = "consumer_grp1")
	public String consumeMessage(Course course) {
		message = course.getCourseId() + " message is consumed from topic";
		return message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
