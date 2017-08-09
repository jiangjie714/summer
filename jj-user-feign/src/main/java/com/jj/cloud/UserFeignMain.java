package com.jj.cloud;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.context.request.RequestContextHolder;

import com.google.common.base.Strings;

import feign.RequestInterceptor;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableRedisHttpSession
public class UserFeignMain {

	public static void main(String[] args) {
		 SpringApplication application = new SpringApplication(UserFeignMain.class);
	     application.setBannerMode(Banner.Mode.OFF);
	     application.run( args);  
	}
	
//	@Bean
//    public RequestInterceptor requestInterceptor() {
//        return requestTemplate -> {
//            String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
//            if (!Strings.isNullOrEmpty(sessionId)) {
//                requestTemplate.header("Cookie", "SESSION=" + sessionId);
//            }
//        };
//    }



}
