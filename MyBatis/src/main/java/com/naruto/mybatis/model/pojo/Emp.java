package com.naruto.mybatis.model.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description: 员工信息
 */
@Data
public class Emp {

    private Integer id;
    private String empName;
    private Integer age;
    private BigDecimal empSalary;

}
