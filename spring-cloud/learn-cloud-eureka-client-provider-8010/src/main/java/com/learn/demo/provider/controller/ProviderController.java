package com.learn.demo.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/provider")
public class ProviderController {

    @Value(value = "${server.port}")
    private Integer port;

    @GetMapping("/getPort")
    public Integer getPort(){
        System.out.println("=============="+port);
        return port;
    }

}
