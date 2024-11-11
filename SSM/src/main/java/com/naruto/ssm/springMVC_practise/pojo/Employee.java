package com.naruto.ssm.springMVC_practise.pojo;

import com.naruto.ssm.springMVC_practise.common.annotation.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * @Author
 * @Date 2024/11/9 18:36
 * @Description:
 */
@PropertySource(value = "classpath:internationalization/*.properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Integer id;

    // 姓名
    @NotEmpty(message = "姓名不能为空")
    private String name;

    // 年龄
    @Max(value = 120, message = "年龄不超过120岁")
    @Min(value = 1, message = "年龄不低于1岁")
    @NotNull(message = "年龄不能为空")
    private Integer age;

    // 邮箱
    @Email(message = "邮箱格式不正确")
    private String email;

    // 性别
//    @Pattern(regexp = "^男$|^女$", message = "性别只能为：男 或 女")  // 使用正则表达式校验
//    @Gender(message = "性别只能为：男 或 女")  // 使用自定义注解校验
    @Gender(message = "{gender.message}")  // 国际化语言错误提示  message = "{}" 占位符
    private String gender;

    // 地址
    private String address;

    // 工资
    private BigDecimal salary;
}
