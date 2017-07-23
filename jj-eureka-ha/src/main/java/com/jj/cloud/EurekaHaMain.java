package com.jj.cloud;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka ha 的应用
 * @author jie
 * 测试已经成功
 * 
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaHaMain {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(EurekaHaMain.class);
	     application.setBannerMode(Banner.Mode.OFF);
	     application.run( args);
	}

}
