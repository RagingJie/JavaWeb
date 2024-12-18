package com.naruto.ssm.springMVC_practise;

import com.naruto.ssm.util.SeparatorUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author
 * @Date 2024/11/8 14:20
 * @Description:
 */
@EnableTransactionManagement
@EnableScheduling
@SpringBootApplication
public class PractiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(PractiseApplication.class, args);
        SeparatorUtil.getSeparator();
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tRestFul架构风格练习项目启动.....");
        SeparatorUtil.getSeparator();
    }
}
