package org.learn.dubbo.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
  * @description TODO
  * @author lbx
  * @date 2022/1/19 15:15
  * @version 1.0.0
 **/
public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:consumer.xml");
        context.start();
        // 获取远程服务代理
        HelloService demoService = (HelloService)context.getBean("helloService");
        // 执行远程方法
        String hello = demoService.sayHello("world");
        // 显示调用结果
        System.out.println( hello );
    }
}
