package com.jj.cloud;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableCaching
@EnableEurekaClient
public class RedisSessionShareMain {

	
	public static void main(String[] args) {
		 SpringApplication application = new SpringApplication(RedisSessionShareMain.class);
	     application.setBannerMode(Banner.Mode.OFF);
	     application.run( args);
	}
}
