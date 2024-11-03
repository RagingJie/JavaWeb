package com.naruto.ssm.aop;

import com.naruto.ssm.aop.calculator.MathCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author
 * @Date 2024/11/3 3:11
 * @Description:
 */
@SpringBootTest
public class AopApplicationTests {

    // 设计模式：依赖倒置；依赖接口，而不是依赖实现。实现可能会经常变。

    final int x = 1000;
    final int y = 20;

    @Autowired
    MathCalculator mathCalculator;

    @Test
    void add() {
        int num = mathCalculator.add(x, y);
//        System.out.printf("%d+%d=%d", x, y, num);
    }
}
