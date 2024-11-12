package com.naruto.ssm.springMVC_practise.common.vo.responseVo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author
 * @Date 2024/11/12 1:05
 * @Description:
 */
@Data  // 将age脱敏
public class EmployeeResponseVo {
    private Integer id;
    private String name;
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;
}
