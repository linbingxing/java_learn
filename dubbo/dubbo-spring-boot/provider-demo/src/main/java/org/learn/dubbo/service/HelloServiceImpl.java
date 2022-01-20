package org.learn.dubbo.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.learn.dubbo.HelloService;
import org.springframework.beans.factory.annotation.Value;

/**
  * @description TODO
  * @author lbx
  * @date 2022/1/20 12:49
  * @version 1.0.0
 **/
@DubboService(version = "1.0")
public class HelloServiceImpl implements HelloService {


    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceName;


    @Override
    public String sayHello(String name) {
        return String.format("[%s] : Hello, %s", serviceName, name);
    }
}
