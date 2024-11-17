package com.naruto.mybatis.model.vo.requestVo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class AddEmpVo implements Serializable {

    private final static long serialVersionUID = 1L;

    @NotBlank(message = "员工姓名不能为空")
    private String empName;

    @NotNull(message = "员工年龄不能为空")
    @Min(value = 1, message = "最小年龄不低于1岁")
    @Max(value = 120, message = "最小年龄不高于120岁")
    private Integer age;

    @Min(value = 0, message = "员工工资不能为负数")
    private BigDecimal empSalary;
}
