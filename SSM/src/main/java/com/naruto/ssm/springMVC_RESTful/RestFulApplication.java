package com.naruto.ssm.springMVC_RESTful;

import com.naruto.ssm.util.SeparatorUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author
 * @Date 2024/11/8 14:20
 * @Description:
 */
@EnableTransactionManagement
@EnableScheduling
@SpringBootApplication
public class RestFulApplication {

    public static void main(String[] args) {
        SeparatorUtil.getSeparator();
        SpringApplication.run(RestFulApplication.class, args);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tRestFul架构风格项目启动.....");
        SeparatorUtil.getSeparator();
    }
}
