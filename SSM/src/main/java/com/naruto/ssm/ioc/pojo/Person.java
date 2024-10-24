package com.naruto.ssm.ioc.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author
 * @Date 2024/10/18 10:21
 * @Description:
 */
@AllArgsConstructor
public class Person implements Serializable {

    // 年龄
    private int age;
    // 姓名
    private String name;
    // 住址
    private String address;
    // 身高
    private double height;

    public Person() {
        System.out.println("Person创建......");
    }
}
