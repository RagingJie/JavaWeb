package com.naruto.ssm.aop;

import com.naruto.ssm.aop.calculator.Impl.MathCalculatorImpl;
import com.naruto.ssm.aop.calculator.MathCalculator;
import com.naruto.ssm.aop.proxy.dynamic.DynamicProxy;
import com.naruto.ssm.aop.proxy.statics.CalculatorStaticProxy;
import com.naruto.ssm.aop.service.Impl.UserServiceImpl;
import com.naruto.ssm.aop.service.UserService;
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
    void test02() {
        MathCalculator mathCalculator = new MathCalculatorImpl();
        DynamicProxy dynamicProxy = new DynamicProxy();
        MathCalculator proxy = (MathCalculator) dynamicProxy.createProxy(mathCalculator);
        int divide = proxy.divide(x, y);
        System.out.println(divide);
    }

    @Test
    void test03() {
        DynamicProxy dynamicProxy = new DynamicProxy();
        UserService proxy = (UserService) dynamicProxy.createProxy(new UserServiceImpl());
        proxy.save("王老吉");
    }
}
