package org.learn.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
  * @description TODO
  * @author lbx
  * @date 2022/1/20 13:22
  * @version 1.0.0
 **/
@EnableAutoConfiguration
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }
}
