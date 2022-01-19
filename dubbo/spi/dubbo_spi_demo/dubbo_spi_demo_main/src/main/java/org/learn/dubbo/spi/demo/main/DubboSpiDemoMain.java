package org.learn.dubbo.spi.demo.main;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.learn.dubbo.spi.demo.api.HelloService;

/**
  * @description TODO
  * @author lbx
  * @date 2022/1/19 9:05
  * @version 1.0.0
 **/
public class DubboSpiDemoMain {

    public static void main(String[] args) {

        ExtensionLoader<HelloService> extensionLoader = ExtensionLoader.getExtensionLoader(HelloService.class);


        HelloService helloService = extensionLoader.getExtension("hello");
        helloService.say();


        HelloService hello2Service = extensionLoader.getExtension("hello2");
        hello2Service.say();


        //获取默认
        HelloService hello3Service = extensionLoader.getExtension("true");
        hello3Service.say();
    }
}
