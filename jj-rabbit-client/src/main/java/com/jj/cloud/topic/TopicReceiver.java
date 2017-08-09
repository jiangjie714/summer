package com.jj.cloud.topic;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver {
	private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;
    @Autowired
    private EurekaClient  eurekaClient;
    
	 @RabbitHandler
	 public void process(String message) {
	        System.out.println("Topic Receiver1  : " + message);
	        ServiceInstance instance = client.getLocalServiceInstance();
	        InstanceInfo instanceInfo= this.eurekaClient.getNextServerFromEureka("rabbit-client", false);
	        logger.warn(instanceInfo.getHomePageUrl()+": host:" + instance.getHost() + ", service_id:" 
	        + instance.getServiceId() + ",Topic Receiver1 : " + message);
	  }
}
