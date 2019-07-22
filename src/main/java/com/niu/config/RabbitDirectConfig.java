package com.niu.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ami on 2019/7/22.
 * rabbit 的 direct 接收的
 * 消息到达 DirectExchange时 被转发到与该条消息routing key相同的Queue
 */
@Configuration
public class RabbitDirectConfig {
    public final static String DIRECTNAME = "sang-direct";

    @Bean
    Queue queue() {
        return new Queue("hello-queue");
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DIRECTNAME, true, false);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue())
                .to(directExchange()).with("direct");
    }
}
