package com.niu.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * Created by ami on 2019/7/22.
 * 所有到达FanoutExchange的消息转发给所有与它绑定的Queue
 */
public class RabbitFanoutConfig {
    public final static String FANOUTNAME = "sang-fanout";
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUTNAME, true, false);
    }
    @Bean
    Queue queueOne() {
        return new Queue("queue-one");
    }
    @Bean
    Queue queueTwo() {
        return new Queue("queue-two");
    }
    @Bean
    Binding bindingOne() {
        return BindingBuilder.bind(queueOne()).to(fanoutExchange());
    }
    @Bean
    Binding bindingTwo() {
        return BindingBuilder.bind(queueTwo()).to(fanoutExchange());
    }

}
