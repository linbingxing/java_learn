package org.learn.dubbo.spi.demo.main;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.learn.dubbo.spi.demo.api.HelloService;

/**
  * @description TODO
  * @author lbx
  * @date 2022/1/19 10:29
  * @version 1.0.0
 **/
public class DubboSpiAdaptiveMain {

    public static void main(String[] args) {
        URL url = URL.valueOf("test://localhost/hell0?hello.service=hello");

        HelloService helloService = ExtensionLoader.getExtensionLoader(HelloService.class).getAdaptiveExtension();
        helloService.say(url);
    }
}
