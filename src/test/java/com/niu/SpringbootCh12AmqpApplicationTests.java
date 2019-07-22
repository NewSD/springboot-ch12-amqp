package com.niu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCh12AmqpApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Test
	public void directTest(){
		rabbitTemplate.convertAndSend("hello-queue","hello direct!");

	}

}
