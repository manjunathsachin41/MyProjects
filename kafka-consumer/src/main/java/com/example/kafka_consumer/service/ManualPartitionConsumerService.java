package com.example.kafka_consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class ManualPartitionConsumerService {
	
	private static final Logger logger = LoggerFactory.getLogger(ManualPartitionConsumerService.class);

	@KafkaListener(id = "paymentListenerId", 
			topicPartitions = {
			@TopicPartition(topic = "paymentTopic", partitions = { "1", "2" })})
	public void listenToSpecificPartitions(String message) {
		logger.info("Received message: " + message);
	}

}
