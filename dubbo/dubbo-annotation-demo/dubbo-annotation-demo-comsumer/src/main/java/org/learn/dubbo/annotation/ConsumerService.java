package org.learn.dubbo.annotation;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @author lbx
 * @version 1.0.0
 * @description TODO
 * @date 2022/1/20 9:20
 **/
@Component
public class ConsumerService {

    @Reference
    private HelloService helloService;

    public String sayHello(String name) {
        return helloService.sayHello(name);
    }
}
