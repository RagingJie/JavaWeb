package com.naruto.ssm.springMVC_practise.common.vo.requestVo;

import com.naruto.ssm.springMVC_practise.common.annotation.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "员工信息")
public class EmployeeAddVo {

    // 姓名
    @NotEmpty(message = "姓名不能为空")
    @Schema(description = "姓名")
    private String name;

    // 年龄
    @Max(value = 120, message = "年龄不超过120岁")
    @Min(value = 1, message = "年龄不低于1岁")
    @NotNull(message = "年龄不能为空")
    @Schema(description = "年龄")
    private Integer age;

    // 邮箱
    @Schema(description = "邮箱")
    @Email(message = "邮箱格式不正确")
    private String email;

    // 性别
    // @Pattern(regexp = "^男$|^女$", message = "性别只能为：男 或 女")  // 使用正则表达式校验
    // @Gender(message = "{gender.message}")  // 国际化语言错误提示  message = "{}" 占位符
    @Gender(message = "性别只能为：男 或 女")  // 使用自定义注解校验
    @Schema(description = "性别")
    private String gender;

    // 地址
    @Schema(description = "地址")
    private String address;

    // 工资
    @Schema(description = "工资")
    private BigDecimal salary;
}
