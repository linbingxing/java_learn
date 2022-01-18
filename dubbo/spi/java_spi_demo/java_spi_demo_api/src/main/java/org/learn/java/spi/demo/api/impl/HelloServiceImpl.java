package org.learn.java.spi.demo.api.impl;

import org.learn.java.spi.demo.api.HelloService;

/**
 * @author lbx
 * @version 1.0.0
 * @description TODO
 * @date 2022/1/18 9:13
 **/
public class HelloServiceImpl implements HelloService {

    @Override
    public void say() {
        System.out.println("hello world");
    }
}
