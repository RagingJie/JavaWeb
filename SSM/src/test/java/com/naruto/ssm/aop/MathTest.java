package com.naruto.ssm.aop;

import com.naruto.ssm.aop.calculator.Impl.MathCalculatorImpl;
import com.naruto.ssm.aop.calculator.MathCalculator;
import com.naruto.ssm.aop.proxy.statics.CalculatorStaticProxy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author
 * @Date 2024/11/3 13:25
 * @Description:
 */
@SpringBootTest
public class MathTest {

    final int x = 100;
    final int y = 20;

    @Test
    void test01() {
        MathCalculator mathCalculator = new MathCalculatorImpl();
        int resultOne = mathCalculator.add(x, y);
//        System.out.println(resultOne);

        CalculatorStaticProxy proxy = new CalculatorStaticProxy(mathCalculator);
        System.out.println("======================================");
        int resultTwo = proxy.add(x, y);
//        System.out.println(resultTwo);
    }

    @Test
    void test02(){

    }
}
