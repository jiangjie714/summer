package com.jj.cloud.object;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import com.jj.cloud.domain.Mat;
import com.jj.cloud.domain.Receiver;
import com.jj.cloud.domain.User;
import com.jj.cloud.mapper.ReceiverMapper;

@Component
@RabbitListener(queues = "object_mat")
public class ObjectReceiver2 {
	private final Logger logger = Logger.getLogger(getClass());
	
	@Value("${server.port}")
    String port;
	
	@Autowired
    private DiscoveryClient client;
	@Autowired
	private  ReceiverMapper receiverMapper;
	
    @RabbitHandler
    public void process(Mat mat) {
        System.out.println("Receiver object : " + mat);
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.warn("/add, host:" + instance.getHost() + ", service_id:" 
        + instance.getServiceId() + ",Receiver object : " + mat);
        Receiver re = new Receiver();
        re.setRsid(mat.getId());
        re.setRsname(mat.getName());
        re.setRsport(port+"");
        receiverMapper.insert(re);
    }
}
