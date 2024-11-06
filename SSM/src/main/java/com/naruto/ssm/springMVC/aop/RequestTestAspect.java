package com.naruto.ssm.springMVC.aop;

import com.naruto.ssm.springMVC.pojo.Person;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author
 * @Date 2024/11/6 21:08
 * @Description: 使用环绕通知，监控RequestTest的所有方法
 */
@Aspect
@Component
public class RequestTestAspect {

    @Pointcut("execution(* com.naruto.ssm.springMVC.controller.RequestTestController.*(..))")
    public void setPoint() {
    }


    @Around("setPoint()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        // 返回值
        Object object = null;
        // 方法传的参数
        Object[] args = pjp.getArgs();
        // 签名
        Signature signature = pjp.getSignature();
        System.out.println("【切面】切入的全签名 => " + signature);
        String name = signature.getName();
        try {
            System.out.println("【环绕通知 - 切面】前置通知，方法【" + name + "】被调用，参数为 => " + Arrays.toString(args));
            // 执行方法
            pjp.proceed(args);
            System.out.println("【环绕通知 - 切面】返回通知，方法【" + name + "】执行后，返回值为 => " + object);
        } catch (Exception e) {
            System.out.println("【环绕通知 - 切面】异常通知，方法【" + name + "】发生异常，异常信息为 => " + e.getCause());
            throw e;  // 让别人能够感知到
        } finally {
            System.out.println("【环绕通知 - 切面】后置通知，方法【" + name + "】结束");
        }

        // 返回结果
        return object;
    }
}
