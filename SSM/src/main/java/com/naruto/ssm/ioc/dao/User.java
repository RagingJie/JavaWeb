package com.naruto.ssm.ioc.dao;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author
 * @Date 2024/10/23 1:53
 * @Description:
 */
@Data
public class User {

    private String username;
    private String password;

    private Car car;

    @Autowired
    public void setCar(Car car) {
        this.car = car;
        System.out.println("自动注入setCar...........");
    }

    public User() {
        System.out.println("构造User......");
    }

    public void initUser() {
        System.out.println("@Bean 初始化.......User");
    }

    public void destroyUser() {
        System.out.println("@Bean 销毁.......User");
    }
}
