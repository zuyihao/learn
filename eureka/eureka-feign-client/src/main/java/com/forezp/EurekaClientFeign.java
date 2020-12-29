package com.forezp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client", configuration = FeignConfig.class)
public interface EurekaClientFeign {

    @RequestMapping("/hi")
    String sayHiFromClient(@RequestParam(value = "name") String name);
}
