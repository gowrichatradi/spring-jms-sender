package com.gowri.config;

import com.gowri.model.JmsSender;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class JmsSenderConfig {

    @Value("${activemq.broker-url}")
    private String brokerUrl;

//    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrl);
        return activeMQConnectionFactory;
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory(){
        return new CachingConnectionFactory(activeMQConnectionFactory());
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        return new JmsTemplate(cachingConnectionFactory());
    }

    @Bean
    public JmsSender sender(){
        return new JmsSender();
    }

}
