package com.forezp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RibbonController {

    @Autowired
    RibbonService ribbonService;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hi")
    public String hi(@RequestParam(required = false,defaultValue = "forezp") String name){
        return ribbonService.hi(name);
    }
    @GetMapping("/test")
    public String testRibbon(){
        List<ServiceInstance> instanceList = discoveryClient.getInstances("eureka-client");
        ServiceInstance instance = loadBalancerClient.choose("eureka-client");
        return instance.getHost()+":"+instance.getPort();
    }
}
