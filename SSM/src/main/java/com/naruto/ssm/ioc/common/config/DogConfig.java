package com.naruto.ssm.ioc.common.config;

import com.naruto.ssm.ioc.pojo.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author
 * @Date 2024/10/23 1:23
 * @Description:
 */
@Configuration // 告诉Spring容器，这是一个配置类
public class DogConfig {

    @Bean("dog")
    public Dog dog() {
        return new Dog();
    }

}
