package org.learn.dubbo.spi.demo.api;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author lbx
 * @version 1.0.0
 * @interfaceName HelloService
 * @description TODO
 * @date 2022/1/19 9:02
 **/
@SPI(value = "hello")
public interface HelloService {


    public void  say();

    @Adaptive
    public void say(URL url);
}
