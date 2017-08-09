package com.jj.cloud.service;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user")
public interface UserService {

	@RequestMapping(value = "/add" ,method = RequestMethod.GET)
	public Object add(@RequestParam(value = "a", required = false )  Integer a,
			@RequestParam (value = "b", required = false) Integer b);
	
	@RequestMapping(value = "/infourl" ,method = RequestMethod.GET)
	public String  serviceUrl();

	@RequestMapping(value = "/instance-info" ,method = RequestMethod.GET)
	public ServiceInstance showInfo() ;
}
