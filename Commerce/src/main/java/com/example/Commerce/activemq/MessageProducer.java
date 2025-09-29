package com.example.Commerce.activemq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private JmsTemplate jmsTemplate;
    
    private static final Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    public void sendMessage(String destination, String message) {
        jmsTemplate.convertAndSend(destination, message);
        logger.info("Sent message to " + destination + ": " + message);
    }
}
