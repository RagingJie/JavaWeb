package com.naruto.mybatis.model.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private Integer id;
    private String customerName;
    private String phone;

    // 保存的订单信息
    List<Order> orders;
}
