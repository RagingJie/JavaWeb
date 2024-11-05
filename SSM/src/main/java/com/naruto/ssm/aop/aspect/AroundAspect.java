package com.naruto.ssm.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author
 * @Date 2024/11/5 0:43
 * @Description:
 */
@Order(3)
@Aspect
@Component
public class AroundAspect {

    // 切入的是MathCalculator接口的全部方法
    @Pointcut("execution(* com.naruto.ssm.aop.calculator.MathCalculator.*(..))")
    public void pointCut() {
    }

    // 环绕通知，整个环绕通知与JDK的动态代理思想相似
    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {  // ProceedingJoinPoint 可推进切入点
        // 获取目标方法的参数
        Object[] args = pjp.getArgs();
        // 返回值
        Object result = null;

        // 捕获异常
        try {
            System.out.println("【环绕 - 前置通知】");
            // 接受传入参数的，proceed实现修改目标方法执行用的参数
            result = pjp.proceed(args); // 推荐方法继续执行的切点，相当于反射的 method.invoke()  返回值为null时，会报AopInvocationException
            System.out.println("【环绕 - 返回通知】，返回值：" + result);
        } catch (Throwable e) {
            System.out.println("【环绕 - 异常通知】，异常信息：" + e.getMessage());
            throw e;  // 让别人继续感知
        } finally {
            System.out.println("【环绕 - 后置通知】");
        }

        // 方法返回值
        return result;
    }
}
