package com.naruto.ssm.ioc.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author
 * @Date 2024/11/1 0:15
 * @Description:
 */
@Data
@Component
// @PropertySource 注解主要用于加载 .properties 文件中的属性。然而，它不支持直接加载 .yml 或 .yaml 文件。
@PropertySource(value = "classpath:pig.properties", encoding = "UTF-8")  // 说明属性来源，把指定的文件导入容器中，供我们取值使用
public class Pig {

    @Value("${pig.name}")
    private String name;

    @Value("${pig.age}")
    private Integer age;


    // @PropertySource总结
    // 1、classpath:cat.properties：从自己的项目类路径下找
    // 2、classpath*:Log4j-charsets.properties：从所有包的类路径下找

}
