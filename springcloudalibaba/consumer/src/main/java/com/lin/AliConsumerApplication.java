package com.lin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.*"})
@SpringBootApplication
@EnableDiscoveryClient //服务发现注解
public class AliConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AliConsumerApplication.class,args);
    }
}
