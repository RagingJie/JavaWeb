package com.naruto.ssm.ioc.dao;

import lombok.Data;

import java.util.Date;

/**
 * @Author
 * @Date 2024/10/25 2:12
 * @Description:
 */
@Data
public class Car {

    private String name;

    private Date createTime;

    private Double weight;
}
