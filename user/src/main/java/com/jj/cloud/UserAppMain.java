package com.jj.cloud;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


import com.google.common.base.Strings;

import feign.RequestInterceptor;

import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@SpringBootApplication
@EnableEurekaClient
@EnableRedisHttpSession
public class UserAppMain {

	public static void main(String[] args) {
		 SpringApplication application = new SpringApplication(UserAppMain.class);
	     application.setBannerMode(Banner.Mode.OFF);
	     application.run( args);

	}
	
	/**
     * Tomcat8.5不允许cookie中有空格,为什么会有空格还不知道,使用spring-session带参数_s的时候会出现
     * https://github.com/spring-projects/spring-session/issues/605
     *
     */
//    @Bean
//    public EmbeddedServletContainerCustomizer customizer() {
//        return container -> {
//            if (container instanceof TomcatEmbeddedServletContainerFactory) {
//                TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
//                tomcat.addContextCustomizers(context -> context.setCookieProcessor(new LegacyCookieProcessor()));
//            }
//        };
//    }

//    @Bean
//    public RequestInterceptor requestInterceptor() {
//        return requestTemplate -> {
//            RequestAttributes attributes = RequestContextHolder.currentRequestAttributes();
//            String sessionId = attributes.getSessionId();
//            if (!Strings.isNullOrEmpty(sessionId)) {
//                requestTemplate.header("Cookie", "SESSION=" + sessionId);
//            }
//        };
//    }

}
