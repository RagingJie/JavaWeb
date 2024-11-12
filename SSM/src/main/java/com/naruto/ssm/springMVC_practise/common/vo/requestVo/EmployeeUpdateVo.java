package com.naruto.ssm.springMVC_practise.common.vo.requestVo;

import com.naruto.ssm.springMVC_practise.common.annotation.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class EmployeeUpdateVo {
    @NotNull(message = "id不能未空")
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;
}
