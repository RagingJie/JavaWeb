package com.naruto.mybatis.aspect;


import com.naruto.mybatis.utils.SeparatorUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(1)
public class LogAspect {

    @Pointcut("execution(* com.naruto.mybatis.service.Impl.EmpServiceImpl.*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        // 分割线
        SeparatorUtil.getSeparator();
        // 获取方法请求参数
        Object[] args = pjp.getArgs();
        // 返回结果参数
        Object result = null;
        try {
            System.out.println("【环绕通知 - 切面 - 前置通知】，方法参数为 => " + Arrays.toString(args));
            result = pjp.proceed(args);
            System.out.println("【环绕通知 - 切面 - 返回通知】，方法执行后，返回值为 => " + result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("【环绕通知 - 切面 - 异常通知】，异常信息为 => " + e.getMessage());
            throw new Exception(e.getMessage());
        } finally {
            System.out.println("【环绕通知 - 切面 - 后置通知】，方法执行后，参数为 => " + Arrays.toString(args));
        }
        SeparatorUtil.getSeparator();
        // 返回结果
        return result;
    }
}
