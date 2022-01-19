package org.learn.dubbo.spi.demo.api.impl;

import org.apache.dubbo.common.URL;
import org.learn.dubbo.spi.demo.api.HelloService;

/**
 * @author lbx
 * @version 1.0.0
 * @description TODO
 * @date 2022/1/19 9:03
 **/
public class HelloServiceImpl implements HelloService {
    @Override
    public void say() {
        System.out.println("Dubbo Say Hello ");
    }

    @Override
    public void say(URL url) {
        System.out.println("Dubbo Say Hello "+url);
    }
}
