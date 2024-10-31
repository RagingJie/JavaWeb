package com.naruto.ssm.ioc.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

/**
 * @Author
 * @Date 2024/10/31 17:38
 * @Description:
 */
@Data
@ToString
@Repository
@PropertySource(value = "classpath:conf/cat.properties")
public class Cat {

    /*
        1、@Value("字面值")：直接赋值
        2、@Value("${key}")：动态从配置文件中取出某一项的值
        3、@Value("#{SpEL}")：Spring Expression Language：Spring表达式语言
    */
    // 名字
    @Value("小阿猫")
    private String name;
    // 年龄
    @Value("${cat.age:88}")  // 默认值，如果获取不到相应的配置参数的话，会取默认值 88
    private Integer age;
    // 体重
    @Value("#{ 1 > 2 ? 15.2 : 12.5 }")
    private Double weight;

    @Value("#{T(java.util.UUID).randomUUID().toString().replace(\"-\",\"\")}")
    private String id;

    @Value("#{new String(\"AHjkdn\").toLowerCase()}")
    private String sw;

    @Value("${cat.height}")
    private Double height;

    public Cat() {
        System.out.println("猫的无参构造方法..........");
    }

}
