package com.study.springboot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


// 两种方式：
// 1、将DogProperties放入容器中，然后类上加上@ConfigurationProperties
// 2、类上不加@Component，在类上加@EnableConfigurationProperties(DogProperties.class)

// @ConfigurationProperties作用，将类的属性与配置文件中的参数绑定，实现自动注入
@ConfigurationProperties(prefix = "dog")
//@Component
@Data
public class DogProperties {

    private String name;
    private Integer age;
    private String sex;

}
