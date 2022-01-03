package com.learn.demo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderApplication8010 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication8010.class,args);
    }
}
