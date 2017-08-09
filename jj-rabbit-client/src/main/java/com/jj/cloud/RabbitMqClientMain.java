package com.jj.cloud;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan
public class RabbitMqClientMain {

	public static void main(String[] args) {
		 SpringApplication application = new SpringApplication(RabbitMqClientMain.class);
	     application.setBannerMode(Banner.Mode.OFF);
	     application.run( args);  
	}
}
