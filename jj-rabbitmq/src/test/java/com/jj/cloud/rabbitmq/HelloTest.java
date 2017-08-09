package com.jj.cloud.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jj.cloud.*;
import com.jj.cloud.test.TestSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTest {

	@Autowired
	private TestSender helloSender;

	@Test
	public void hello() throws Exception {
		helloSender.send();
	}


}