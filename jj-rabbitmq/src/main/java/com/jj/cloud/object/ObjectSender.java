package com.jj.cloud.object;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jj.cloud.domain.Mat;
import com.jj.cloud.domain.User;


@Component
public class ObjectSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(User user) {
		System.out.println("Sender object: " + user.toString());
		this.rabbitTemplate.convertAndSend("object", user);
	}
	
	public void sendMat	(Mat mat) {
		System.out.println("Sender object: " + mat.toString());
		this.rabbitTemplate.convertAndSend("object_mat", mat);
	}
}
