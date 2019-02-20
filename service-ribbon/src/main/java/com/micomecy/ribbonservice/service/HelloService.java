package com.micomecy.ribbonservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @program: parent
 * @Date: 2019.2.20 下午 10:42
 * @Author: MicoMecy
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;
    //1.创建熔断器功能
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name){
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class );
    }

    public String hiError(String name){
        return "hi "+name+" sorry,error";
    }
}
