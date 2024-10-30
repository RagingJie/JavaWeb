package com.naruto.ssm.ioc.common.config;

import com.naruto.ssm.ioc.common.condition.MacCondition;
import com.naruto.ssm.ioc.common.condition.WindowsCondition;
import com.naruto.ssm.ioc.pojo.Dog;
import com.naruto.ssm.ioc.pojo.Person;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @Author
 * @Date 2024/10/23 1:23
 * @Description:
 */
@Configuration // 告诉Spring容器，这是一个配置类
public class DogConfig {


    //    @Lazy
    // Spring在底层有多组件名字判定bug
//    @Bean("dog1")
//    @ConditionalOnMissingBean(value = MacCondition.class)  // 类不存在时，将dog1放入ioc容器中
//    public Dog dog1() {
//        return new Dog("@ConditionalOnMissingBean");
//    }

    @Bean("dog2")
    @ConditionalOnBean(value = WindowsCondition.class) // 类存在时，将dog2放入ioc容器中
    public Dog dog2() {
        return new Dog("@ConditionalOnBean");
    }

    @Bean("dog3")
    @ConditionalOnResource(resources = "classpath:application.yml")  // 资源存在时，放入ioc容器中，
    public Dog dog3() {
        return new Dog("@ConditionalOnResource");
    }

    @Bean
    public Dog dog4() {
        return new Dog("Dog4...........");
    }

}
