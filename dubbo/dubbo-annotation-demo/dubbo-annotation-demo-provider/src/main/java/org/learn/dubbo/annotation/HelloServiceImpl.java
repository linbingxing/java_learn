package org.learn.dubbo.annotation;

import org.apache.dubbo.config.annotation.Service;

/**
  * @description TODO
  * @author lbx
  * @date 2022/1/20 9:31
  * @version 1.0.0
 **/
@Service
public class HelloServiceImpl implements HelloService{


    @Override
    public String sayHello(String name) {
        return "hello  "+ name;
    }
}
