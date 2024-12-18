package com.naruto.ssm.springMVC_practise.pojo;

import com.naruto.ssm.springMVC_practise.common.annotation.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.PropertySource;

import jakarta.validation.constraints.*;
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
    private String name;
    private Integer age;
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;
}
