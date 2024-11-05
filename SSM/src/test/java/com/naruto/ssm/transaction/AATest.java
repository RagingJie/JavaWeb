package com.naruto.ssm.transaction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionManager;

/**
 * @Author
 * @Date 2024/11/5 22:38
 * @Description:
 */
@SpringBootTest
public class AATest {

    @Autowired
    TransactionManager transactionManager;

    @Test
    void test01(){
        System.out.println(transactionManager);
        System.out.println(transactionManager.getClass());
    }
}
