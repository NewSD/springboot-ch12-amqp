package com.niu.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ami on 2019/7/22.
 * 根据header将消息路由到 不同的 Queue上,与routing key无关
 */
@Configuration
public class RabbitHeaderConfig {
    public final static String HEADERNAME = "sang-header";
    @Bean
    HeadersExchange headersExchange() {
        return new HeadersExchange(HEADERNAME, true, false);
    }
    @Bean
    Queue queueName() {
        return new Queue("name-queue");
    }
    @Bean
    Queue queueAge() {
        return new Queue("age-queue");
    }
    @Bean
    Binding bindingName() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "sang");
        return BindingBuilder.bind(queueName())
                .to(headersExchange()).whereAny(map).match();
    }
    @Bean
    Binding bindingAge() {
        return BindingBuilder.bind(queueAge())
                .to(headersExchange()).where("age").exists();
    }
}
