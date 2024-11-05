package com.naruto.ssm.transaction;

import com.naruto.ssm.util.SeparatorUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author
 * @Date 2024/11/5 14:43
 * @Description:
 */
@EnableTransactionManagement // 开启基于注解的自动化事务管理
@SpringBootApplication
public class TransactionApplication {

    public static void main(String[] args) {

        SpringApplication.run(TransactionApplication.class, args);

        SeparatorUtil.getSeparator();
        System.out.println("【事务】：学习事务服务启动成功......");
        SeparatorUtil.getSeparator();

    }
}
