package com.lin.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @Value("${server.port}")
    String port;
    @GetMapping(value = "/add")
    public String add() {

        return "服务端nocas端口号:"+port;
    }
}
