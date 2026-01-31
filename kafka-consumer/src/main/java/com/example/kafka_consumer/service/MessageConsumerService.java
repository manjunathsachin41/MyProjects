package com.example.kafka_consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {

	private static final String CONSUMER_GRP1 = "consumer_grp1";

	private static final String TEST_TOPIC = "testTopic";

	private static final Logger logger = LoggerFactory.getLogger(MessageConsumerService.class);

	// @Autowired
	// private KafkaTemplate<String, Customer> kafkaTemplate;

	private String message;

	// There are 3 partitions in testTopic but 4 consumers(methods). The 3 partitions randomly connects
	// to any 3 consumers at any point of time and any one consumer will be left unused.
	
	// Automatically called when message is in topic.
	@KafkaListener(topics = TEST_TOPIC, groupId = CONSUMER_GRP1)
	public String consumeMessageOne(String message) {
		logger.info("Message Consumed One : " + message);
		return message;
	}
	
	@KafkaListener(topics = TEST_TOPIC, groupId = CONSUMER_GRP1)
	public String consumeMessageTwo(String message) {
		logger.info("Message Consumed Two : " + message);
		return message;
	}
	
	@KafkaListener(topics = TEST_TOPIC, groupId = CONSUMER_GRP1)
	public String consumeMessageThree(String message) {
		logger.info("Message Consumed Three : " + message);
		return message;
	}
	
	@KafkaListener(topics = TEST_TOPIC, groupId = CONSUMER_GRP1)
	public String consumeMessageFour(String message) {
		logger.info("Message Consumed Four : " + message);
		return message;
	}

	public String getMessage() {
		return message;
	}

}
