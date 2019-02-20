package com.micomecy.feignservice.interfaces.fallback;

import com.micomecy.feignservice.interfaces.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @program: parent
 * @Date: 2019.2.21 上午 1:03
 * @Author: MicoMecy
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiForClientOne(String name) {
        return "sorry "+name+" this service is miss";
    }
}
