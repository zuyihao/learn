package com.forezp;

import feign.Retryer;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class FeignConfig {

    public Retryer feignRetryer(){
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 5);
    }
}
