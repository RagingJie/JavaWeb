package com.naruto.mybatis.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @description: 员工信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Emp {

    private Integer id;
    private String empName;
    private Integer age;
    private BigDecimal empSalary;

}
