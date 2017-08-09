package com.jj.cloud;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.jj.cloud.filter.PreRequestLogFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableCaching
//@EnableEurekaClient
public class ZuulMain {

	public static void main(String[] args) {
			SpringApplication application = new SpringApplication(ZuulMain.class);
		     application.setBannerMode(Banner.Mode.OFF);
		     application.run( args);
	}
	
	  @Bean
	  public PreRequestLogFilter preRequestLogFilter() {
	    return new PreRequestLogFilter();
	  }

}
