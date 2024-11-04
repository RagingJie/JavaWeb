package com.naruto.ssm.aop.calculator.Impl;

import com.naruto.ssm.aop.calculator.MathCalculator;
import org.springframework.stereotype.Component;

/**
 * @Author
 * @Date 2024/11/3 3:13
 * @Description:
 */

// 日志：
//    1、硬编码：不推荐；耦合：（通用逻辑+专用逻辑）希望不要耦合，耦合太多就是维护地狱
//    2、静态代理：
//          定义：定义一个代理对象，包装这个组件。以后业务的执行，从代理开始，不直接调用组件；
//          特点：定义期间就制定好了互相代理关系

@Component
public class MathCalculatorImpl implements MathCalculator {
    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public int sub(int x, int y) {
        return x - y;
    }

    @Override
    public int multiply(int x, int y) {
        return x * y;
    }

    @Override
    public int divide(int x, int y) {
        return x / y;
    }
}
