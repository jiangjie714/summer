package com.jj.cloud.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import feign.Request;

@RestController
public class UserController {

	private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;
    
    @Autowired
    private EurekaClient  eurekaClient;
    
    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Object add(@RequestParam(value = "a", required = false )  Integer a,
			@RequestParam (value = "b", required = false) Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        logger.warn("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + 
        		", result:" + r +",_"+request.getSession().getAttribute("user"));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("SessionId", request.getSession().getId());
        map.put("ServerPort", "服务端口号为 "+port);
        map.put("result", r);
        return map;
    }
    
    @GetMapping("/infourl")
    public String  serviceUrl(HttpServletRequest request) {
      InstanceInfo instanceInfo= this.eurekaClient.getNextServerFromEureka("user", false);
      return instanceInfo.getHomePageUrl()+",session:"+request.getSession().getId();
    }
    
    /**
     * 本地服务实例的信息
     * @return
     */
    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
      ServiceInstance localServiceInstance = this.client.getLocalServiceInstance();
      return localServiceInstance;
    }
}
