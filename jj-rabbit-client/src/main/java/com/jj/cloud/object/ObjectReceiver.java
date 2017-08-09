package com.jj.cloud.object;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import com.jj.cloud.domain.User;

@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {
	private final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
    private DiscoveryClient client;
	
	@Value("${server.port}")
	private String port;
	
    @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver object : " + user);
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.warn("/add, host:" + instance.getHost() + ", port :" 
        + port+ ",Receiver object : " + user);
       
    }
}
