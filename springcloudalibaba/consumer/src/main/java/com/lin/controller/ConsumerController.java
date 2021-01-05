package com.lin.controller;


import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RefreshScope //动态刷新获取config,config的注解
public class ConsumerController {


    /**
     * 调用nocas上注册的服务
     * 采用restTemplate1+robbin的LoadBalanced注解
     *
     * @return
     */
    @Resource
    private RestTemplate restTemplate1;

    @RequestMapping(value = "/get")
    public String add() {
        String url = "http://huyiju-nacosservice/add";
        System.out.println("进入调用");
        return restTemplate1.getForObject(url, String.class);


    }
}