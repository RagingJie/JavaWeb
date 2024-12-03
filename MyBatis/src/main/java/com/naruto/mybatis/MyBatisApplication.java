package com.naruto.mybatis;

import com.naruto.mybatis.utils.SeparatorUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


@EnableTransactionManagement
@SpringBootApplication
public class MyBatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisApplication.class, args);

        SeparatorUtil.getSeparator();
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t Mybatis练习项目启动........");
        SeparatorUtil.getSeparator();
    }

}
