package com.naruto.mybatis;

import com.naruto.mybatis.utils.SeparatorUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisApplication.class, args);

        SeparatorUtil.getSeparator();
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t Mybatis练习项目启动........");
        SeparatorUtil.getSeparator();
    }

}
