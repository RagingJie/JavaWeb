package com.naruto.mybatis.model.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {

    private Integer id;
    private String address;
    private BigDecimal amount;
    private Long customerId;

    // 对应订单中的客户信息
    private Customer customer;
}
