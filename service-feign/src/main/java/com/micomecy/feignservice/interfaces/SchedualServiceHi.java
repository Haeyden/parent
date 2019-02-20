package com.micomecy.feignservice.interfaces;

import com.micomecy.feignservice.interfaces.fallback.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: parent
 * @Date: 2019.2.20 下午 11:28
 * @Author: MicoMecy
 */
@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class) //指定调用哪一个服务 类似restTemplate
public interface SchedualServiceHi {
    //去找service-hi中的/hi
    @RequestMapping(value = "/hi")
    String sayHiForClientOne(@RequestParam(value = "name") String name);
}
