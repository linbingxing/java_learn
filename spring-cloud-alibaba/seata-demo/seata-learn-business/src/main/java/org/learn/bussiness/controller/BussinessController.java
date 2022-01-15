package org.learn.bussiness.controller;

import org.learn.bussiness.service.IBussinessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BussinessController {

    @Resource
    private IBussinessService bussinessService;

    @GetMapping("/test1")
    public String test1() {
        bussinessService.sale(1, 10, 100d, "zhaoyang");
        return "success";
    }

    @GetMapping("/test2")
    public String test2() {
        bussinessService.sale(1, 101, 100d, "zhaoyang");
        return "success";
    }
}
