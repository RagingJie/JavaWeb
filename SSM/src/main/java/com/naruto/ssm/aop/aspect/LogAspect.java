package com.naruto.ssm.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
    使用切面的步骤：
        1、导入aop依赖
        2、编写切面Aspect
        3、编写通知方法
        4、指定切入点表达式
        5、测试AOP动态织入
*/

/**
 * @Author
 * @Date 2024/11/4 11:28
 * @Description:
 */
@Aspect   // 告诉Spring这个组件是切面
@Component
public class LogAspect {

    /*
        告诉Spring，以下通知何时何地运行？
        何时？
            @Before: 方法执行之前运行
            @AfterReturning：方法执行正常返回结果运行
            @AfterThrowing：方法抛出异常运行
            @After：方法执行之后运行，相当于finally里面运行的代码逻辑（捕获异常里的）
        何地？
            切入点表达式：
                execution(方法的全签名)  []包裹的是可以省略的
                    全写法：[public] int [com.naruto.ssm.aop.calculator.MathCalculator].add(int,int) [throws IndexOutOfBoundsException]
                    省略写法：int add(int,int)
                    也可以用通配符的方式书写 int *(int,int)
                    通配符：*，表示任意字符
    */

    /**
     * @description 开始日志
     */
    @Before("execution(int *(int,int))")
    public void logStart() {
        System.out.println("【切面 - 日志】：开始.....");
    }

    /**
     * @description 结束日志
     */
    @After("execution(int *(int,int))")
    public void logEnd() {
        System.out.println("【切面 - 日志】结束....");
    }

    /**
     * @description 异常日志
     */
    @AfterThrowing("execution(int *(int,int))")
    public void logException() {
        System.out.println("【切面 - 日志】异常.....");
    }

    /**
     * @description 返回日志
     */
    @AfterReturning("execution(int *(int,int))")
    public void logReturn() {
        System.out.println("【切面 - 日志】：返回");
    }
}
