package com.gowri;

import com.gowri.model.JmsSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJmsJmsSenderApplicationTests {

    public static final Logger LOGGER = LoggerFactory.getLogger(SpringJmsJmsSenderApplicationTests.class);

    @Autowired
    private JmsSender jmsSender;

    @Value("${queue.gowri}")
    private String jmsQueue;

    @Test
    public void sendBulkMessage() throws Exception {
        for (int i = 0; i < 2000; i++) {
            jmsSender.sendMessage(jmsQueue, "sample message");
        }
    }

}
