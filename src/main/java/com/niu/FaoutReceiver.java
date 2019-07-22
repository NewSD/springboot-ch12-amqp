package com.niu;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by ami on 2019/7/22.
 */
@Component
public class FaoutReceiver {
    @RabbitListener(queues = "queue-one")
    public void handler1(String message) {
        System.out.println("FanoutReceiver:handler1:" + message);
    }
    @RabbitListener(queues = "queue-two")
    public void handler2(String message) {
        System.out.println("FanoutReceiver:handler2:" + message);
    }
}
