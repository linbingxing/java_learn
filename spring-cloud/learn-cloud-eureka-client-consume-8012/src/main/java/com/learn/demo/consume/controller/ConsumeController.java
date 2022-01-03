package com.learn.demo.consume.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consume")
public class ConsumeController {

    @Resource
    private RestTemplate restTemplate;


    @Bean
    // Ribbon负载均衡
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/getPort")
    public Integer getPort(){
        return restTemplate.getForObject("http://learn-cloud-eureka-client-provider/provider//getPort",Integer.class);
    }
}
