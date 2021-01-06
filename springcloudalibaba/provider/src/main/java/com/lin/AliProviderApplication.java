package com.lin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient//nocas服务发现注解
public class AliProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(AliProviderApplication.class,args);

    }

}