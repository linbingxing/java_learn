package org.learn.dubbo;

import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author lbx
 * @version 1.0.0
 * @description TODO
 * @date 2022/1/20 12:55
 **/

@EnableAutoConfiguration
public class ConsumerApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class).close();
    }

    @DubboReference(version = "1.0")
    private HelloService helloService;

    @Bean
    public ApplicationRunner runner(){
        return args ->logger.info(helloService.sayHello("world"));
    }


}
