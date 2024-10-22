package com.naruto.ssm.ioc.common.config;

import com.naruto.ssm.ioc.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author
 * @Date 2024/10/23 1:21
 * @Description:
 */
@Configuration  // 告诉Spring容器，这是一个配置类
public class PersonConfig {

    @Bean("person")
    public Person ha() {
        Person person = new Person(20, "哈哈", "山东潍坊111", 175.6);
        return person;
    }

    @Bean
    public Person person() {
        Person person = new Person(18, "阿叼", "山东潍坊", 182.5);
        return person;
    }

    @Bean("personOne")
    public Person person1() {
        return new Person();
    }
}
