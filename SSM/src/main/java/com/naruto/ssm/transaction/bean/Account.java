package com.naruto.ssm.transaction.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author
 * @Date 2024/11/5 15:03
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {

    // 主键id
    private int id;
    // 用户名
    private String username;
    // 年龄
    private int age;
    // 余额
    private BigDecimal balance;
}
