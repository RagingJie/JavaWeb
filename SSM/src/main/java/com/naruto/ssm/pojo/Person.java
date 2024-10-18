package com.naruto.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author
 * @Date 2024/10/18 10:21
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    // 年龄
    private int age;
    // 姓名
    private String name;
    // 住址
    private String address;
    // 身高
    private double height;
}
