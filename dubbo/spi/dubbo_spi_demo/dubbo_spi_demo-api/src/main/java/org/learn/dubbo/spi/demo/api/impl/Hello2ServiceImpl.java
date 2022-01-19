package org.learn.dubbo.spi.demo.api.impl;

import org.learn.dubbo.spi.demo.api.HelloService;

/**
 * @author lbx
 * @version 1.0.0
 * @description TODO
 * @date 2022/1/19 9:03
 **/
public class Hello2ServiceImpl implements HelloService {
    @Override
    public void say() {
        System.out.println("Dubbo Say Hello2 ");
    }
}
