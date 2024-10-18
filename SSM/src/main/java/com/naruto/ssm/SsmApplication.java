package com.naruto.ssm;

import com.naruto.ssm.pojo.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class SsmApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(SsmApplication.class, args);
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }


    @Bean("dwajiodaw")
    public Person person() {
        Person person = new Person(18, "阿叼", "山东潍坊", 182.5);
        return person;
    }

}
