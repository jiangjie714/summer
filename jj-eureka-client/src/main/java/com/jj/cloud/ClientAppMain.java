package com.jj.cloud;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClientAppMain {

	public static void main(String[] args) {
		 SpringApplication application = new SpringApplication(ClientAppMain.class);
	     application.setBannerMode(Banner.Mode.OFF);
	     application.run( args);
	}

}
