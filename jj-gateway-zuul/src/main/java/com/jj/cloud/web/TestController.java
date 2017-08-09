package com.jj.cloud.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public Object setSession(HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("SessionId", request.getSession().getId());
        map.put("ServerPort", "服务端口号为 "+port);
        request.getSession().setAttribute("user", "测试用户");
        return map;
    }
    
    @RequestMapping(value = "/removesession", method = RequestMethod.GET)
    public Object removeSession(HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("SessionId", request.getSession().getId());
        map.put("ServerPort", "服务端口号为 "+port);
//        request.getSession().r
        return map;
    }
    
    @RequestMapping(value = "/getsession", method = RequestMethod.GET)
    public Object getSession(HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("SessionId", request.getSession().getId());
        map.put("ServerPort", "服务端口号为 "+port);
        String username =(String)request.getSession().getAttribute("user");
        map.put("username", username);
        return map;
    }
}
