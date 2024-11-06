package com.naruto.ssm.springMVC;

import com.naruto.ssm.util.SeparatorUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author
 * @Date 2024/11/6 14:03
 * @Description: springMVC服务启动类
 */

// 效果：其实是 SpringBoot 做的
// 1、tomcat不用整合
// 2、servlet开发变得简单，不用实现任何接口
// 3、自动解决了乱码等问题
@EnableTransactionManagement  // 开启注解事务
@SpringBootApplication
public class SpringMVCApplication {

    public static void main(String[] args) {
        // 启动服务
        SpringApplication.run(SpringMVCApplication.class, args);
        SeparatorUtil.getSeparator();
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tSpringMVC服务启动......");
        SeparatorUtil.getSeparator();
    }
}
