package com.study.springboot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

//@PropertySource("classpath:person.yaml")  // @PropertySource不能直接扫描yaml文件
@Component
@ConfigurationProperties(prefix = "person") // @ConfigurationProperties声明组件和配置文件的哪些配置项进行绑定
@Data
public class Person {
    private String name;
    private Integer age;
    private Date birthDay;
    private Boolean like;
    private Child child;
    private List<Dog> dogs;
    private Map<String, Cat> cats;
}

@Data
class Dog {
    private String name;
    private Integer age;
}

@Data
class Child {
    private String name;
    private Integer age;
    private Date birthDay;
    private List<String> text;
}

@Data
class Cat {
    private String name;
    private Integer age;
}
