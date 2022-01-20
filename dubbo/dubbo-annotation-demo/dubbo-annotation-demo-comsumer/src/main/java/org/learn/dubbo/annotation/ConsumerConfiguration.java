package org.learn.dubbo.annotation;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
  * @description TODO
  * @author lbx
  * @date 2022/1/20 9:22
  * @version 1.0.0
 **/
@Configuration
@EnableDubbo(scanBasePackages = "org.learn.dubbo")
@PropertySource("classpath:dubbo-consumer.properties")
@ComponentScan(value = {"org.learn.dubbo"})
public class ConsumerConfiguration {
}
