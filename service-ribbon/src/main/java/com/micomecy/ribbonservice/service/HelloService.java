package com.micomecy.ribbonservice.service;

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
    public String hiService(String name){
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class );
    }
}
