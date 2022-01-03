package com.learn.demo.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsumeApplication8012 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumeApplication8012.class,args);
    }
}
