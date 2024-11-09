package com.naruto.ssm.springMVC_RESTful.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author
 * @Date 2024/11/9 18:36
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Integer id;

    // 姓名
    private String name;

    // 年龄
    private Integer age;

    // 邮箱
    private String email;

    // 性别
    private String gender;

    // 地址
    private String address;

    // 工资
    private BigDecimal salary;
}
