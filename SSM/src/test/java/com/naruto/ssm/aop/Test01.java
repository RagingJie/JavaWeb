package com.naruto.ssm.aop;

import com.naruto.ssm.aop.calculator.MathCalculator;
import com.naruto.ssm.aop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author
 * @Date 2024/11/4 14:39
 * @Description:
 */
@SpringBootTest
public class Test01 {

    // 容器中是他的代理对象
    @Autowired
    MathCalculator mathCalculator;

    @Autowired
    UserService userService;

    @Test
    void test01() {
        System.out.println(mathCalculator.getClass());  // 实现类  MathCalculatorImpl$$EnhancerBySpringCGLIB$$52b60a84

//        userService.updateUser(1, 2);
//
//        mathCalculator.add(8,9);

//        userService.getUser("注解",10);   // 失败了，后续再研究吧@args()
//        userService.setUser();

        mathCalculator.divide(10,0);
    }
}
