package org.learn.java.spi.demo.main;

import org.learn.java.spi.demo.api.HelloService;

import java.util.ServiceLoader;


/**
  * @description TODO
  * @author lbx
  * @date 2022/1/18 9:15
  * @version 1.0.0
 **/
public class SpiDemoMain {

    public static void main(String[] args) {
        ServiceLoader<HelloService> services = ServiceLoader.load(HelloService.class);
        for (HelloService service: services) {
            service.say();
        }
    }
}
