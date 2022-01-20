package org.learn.dubbo.annotation.config;

import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
  * @description TODO
  * @author lbx
  * @date 2022/1/20 9:12
  * @version 1.0.0
 **/
@Configuration
@EnableDubbo(scanBasePackages = "org.learn.dubbo")
@PropertySource("classpath:dubbo-provider.properties")
public class ProviderConfiguration {

    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("nacos://192.168.10.40:8848");
        return registryConfig;
    }
}
