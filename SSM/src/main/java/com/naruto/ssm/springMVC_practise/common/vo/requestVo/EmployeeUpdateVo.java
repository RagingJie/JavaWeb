package com.naruto.ssm.springMVC_practise.common.vo.requestVo;

import com.naruto.ssm.springMVC_practise.common.annotation.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "员工信息")
public class EmployeeUpdateVo {
    @NotNull(message = "id不能未空")
    @Schema(description = "员工id")
    private Integer id;
    @Schema(description = "姓名")
    private String name;
    @Schema(description = "年龄")
    private Integer age;
    @Schema(description = "邮箱")
    private String email;
    @Schema(description = "性别")
    private String gender;
    @Schema(description = "地址")
    private String address;
    @Schema(description = "工资")
    private BigDecimal salary;
}
