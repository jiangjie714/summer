package com.jj.cloud.web;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jj.cloud.domain.Mat;
import com.jj.cloud.domain.User;
import com.jj.cloud.object.ObjectSender;
import com.jj.cloud.service.TestServiceImpl;
import com.jj.cloud.topic.TopicReceiver;
import com.jj.cloud.topic.TopicReceiver2;
import com.jj.cloud.topic.TopicSender;
import com.netflix.governator.annotations.binding.Request;

@RestController
public class TestController {
	
	@Autowired
	private TopicSender sender;
	
	@Autowired
	private ObjectSender objectSender;
	
	@Autowired
	private TestServiceImpl testServiceImpl;

	@RequestMapping(value = "/topic", method = RequestMethod.GET)
	public String topicTest() {
		String msg ="success";
//		TopicReceiver t = new TopicReceiver();
//		TopicReceiver2 t2 = new TopicReceiver2();
//		t.process("my testxxx double");
//		t2.process("my t2 double");
		
		
		sender.send1();
		sender.send2();
		return  msg;
	}
	
	@RequestMapping(value = "/object/{name}/{age}", method = RequestMethod.GET)
	public String ObjectTest(@PathVariable String name,@PathVariable int age) {
		String msg ="success";
//		User user = new User();
//		user.setName(name);
//		user.setAge(age);
//		user.setAddress(name+age);
//		objectSender.send(user);
		
		ArrayList<Mat >  list =testServiceImpl.getList();
		for(Mat mat:list) {
			objectSender.sendMat(mat);
		}
		
		return  msg;
	}
}
