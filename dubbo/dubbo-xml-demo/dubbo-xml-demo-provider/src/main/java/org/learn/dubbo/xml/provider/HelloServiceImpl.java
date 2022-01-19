package org.learn.dubbo.xml.provider;

import org.learn.dubbo.xml.HelloService;

/**
  * @description TODO
  * @author lbx
  * @date 2022/1/19 15:10
  * @version 1.0.0
 **/
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
