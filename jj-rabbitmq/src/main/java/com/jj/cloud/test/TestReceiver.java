package com.jj.cloud.test;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "helloWorld")
public class TestReceiver {

	@RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }
}
