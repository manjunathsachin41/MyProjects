package com.example.kafka_producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafka_producer.model.Course;

@Service
public class ProducerService {
	
	@Autowired
	KafkaTemplate<String, Course> kafkaTemplate;

	public String addMessage(Course course) {
		kafkaTemplate.send("telusko", "mycourse", course);
		return "Course added to topic";
	}

}
