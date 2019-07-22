package com.niu;

import com.niu.config.RabbitFanoutConfig;
import com.niu.config.RabbitTopicConfig;
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

	@Test
	public void faoutTest(){
		rabbitTemplate.convertAndSend(RabbitFanoutConfig.FANOUTNAME,null,"hello faout!");
	}

	@Test
	public void topicTest(){
		rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,
				"xiaomi.news","小米新闻...");
		rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,
				"huawei.news","华为新闻...");
		rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,
				"xiaomi.phone","小米手机...");
		rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,
				"huawei.phone","华为手机...");
		rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,
				"phone.news","手机新闻...");



	}

}
