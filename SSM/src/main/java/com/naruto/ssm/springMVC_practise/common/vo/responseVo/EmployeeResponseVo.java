package com.naruto.ssm.springMVC_practise.common.vo.responseVo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author
 * @Date 2024/11/12 1:05
 * @Description:
 */
@Data  // 将age脱敏
@Schema(description = "员工信息")
public class EmployeeResponseVo {
    @Schema(description = "员工id")
    private Integer id;
    @Schema(description = "姓名")
    private String name;
    @Schema(description = "邮箱")
    private String email;
    @Schema(description = "性别")
    private String gender;
    @Schema(description = "地址")
    private String address;
    @Schema(description = "工资")
    private BigDecimal salary;
}
