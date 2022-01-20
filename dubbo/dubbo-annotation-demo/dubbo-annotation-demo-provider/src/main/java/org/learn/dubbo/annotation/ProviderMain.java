package org.learn.dubbo.annotation;

import org.learn.dubbo.annotation.config.ProviderConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
  * @description TODO
  * @author lbx
  * @date 2022/1/20 9:11
  * @version 1.0.0
 **/
public class ProviderMain {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();
        System.in.read();
    }
}
