package com.jj.cloud.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jj.cloud.service.UserService;
import com.netflix.client.http.HttpRequest;

@RestController
public class UserController {
	private final Logger logger = Logger.getLogger(getClass());
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Object add(@RequestParam(value = "a", required = false )  Integer a,
			@RequestParam (value = "b", required = false) Integer b ) {
		System.out.println("lllll");
		return userService.add(a, b);
	}

	@RequestMapping(value = "/infourl", method = RequestMethod.GET)
	public String serviceUrl() {
		logger.info(userService.serviceUrl());
		return userService.serviceUrl();
	}

	@RequestMapping(value = "/instance-info", method = RequestMethod.GET)
	public ServiceInstance showInfo() {
		return userService.showInfo();
	}
}
