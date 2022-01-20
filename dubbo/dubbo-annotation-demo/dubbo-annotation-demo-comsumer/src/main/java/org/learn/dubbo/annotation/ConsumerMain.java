package org.learn.dubbo.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @author lbx
 * @version 1.0.0
 * @description TODO
 * @date 2022/1/20 9:19
 **/
public class ConsumerMain {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        ConsumerService service = context.getBean(ConsumerService.class);
        while (true) {
            System.in.read();
            try {
                String hello = service.sayHello("world");
                System.out.println("result:" + hello);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
