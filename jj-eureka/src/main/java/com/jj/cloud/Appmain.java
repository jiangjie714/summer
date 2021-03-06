package com.jj.cloud;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Appmain  {

	public static void main(String[] args) {
		 SpringApplication application = new SpringApplication(Appmain.class);
	     application.setBannerMode(Banner.Mode.OFF);
	     application.run( args);  
	}

}
