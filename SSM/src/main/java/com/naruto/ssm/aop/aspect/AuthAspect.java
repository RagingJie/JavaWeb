package com.naruto.ssm.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author
 * @Date 2024/11/5 0:15
 * @Description:
 */
@Order(20)
@Component
@Aspect
public class AuthAspect {

    // 切入点
    @Pointcut("execution(int com.naruto.ssm.aop.calculator.MathCalculator.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void start() {
        System.out.println("【切面 - 权限】：开始.....");
    }

    @After("pointCut()")
    public void end() {
        System.out.println("【切面 - 权限】：后置.....");
    }

    @AfterReturning("pointCut()")
    public void returning() {
        System.out.println("【切面 - 权限】：返回.....");
    }

    @AfterThrowing("pointCut()")
    public void throwing() {
        System.out.println("【切面 - 权限】：异常.....");
    }
}
