package com.jj.cloud.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jj.cloud.domain.User;
import com.jj.cloud.object.ObjectSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectTest {

	@Autowired
	private ObjectSender sender;

	@Test
	public void sendOject() throws Exception {
		User user=new User();
		user.setName("neo");
		user.setAge(1234);
		sender.send(user);
	}

}