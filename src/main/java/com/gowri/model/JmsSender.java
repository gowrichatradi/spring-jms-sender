package com.gowri.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class JmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(JmsSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String destination, String message){
        jmsTemplate.convertAndSend(destination, message);
    }
}
