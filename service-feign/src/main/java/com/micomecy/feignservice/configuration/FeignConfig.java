package com.micomecy.feignservice.configuration;

import feign.Retryer;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

/**
 * 自定义Feign的文件
 * @program: parent
 * @Date: 2019.2.25 下午 10:45
 * @Author: MicoMecy
 */
public class FeignConfig {
    @Bean
    public Retryer feignRetryer(){
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 5);
    }
}
