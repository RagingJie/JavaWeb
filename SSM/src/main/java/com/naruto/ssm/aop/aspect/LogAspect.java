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
                    通配符：
                        *：表示任意字符
                        ..：
                            1）、参数位置：表示多个参数，任意类型
                            2）、类型位置：代表多个层级
                     最省略：* *(..)

    */

    /**
     * @description 开始日志
     */
    @Before("execution(int com.naruto.ssm.aop.calculator.MathCalculator.*(..))")  // 建议精确的找位置切入
    public void logStart() {
        System.out.println("【切面 - 日志】：开始.....");
    }

    /**
     * @description 结束日志
     */
    @After("execution(int com.naruto.ssm.aop.calculator.MathCalculator.*(..))")
    public void logEnd() {
        System.out.println("【切面 - 日志】结束....");
    }

    /**
     * @description 异常日志
     */
    @AfterThrowing("execution(int com.naruto.ssm.aop.calculator.MathCalculator.*(..))")
    public void logException() {
        System.out.println("【切面 - 日志】异常.....");
    }

    /**
     * @description 返回日志
     */
    @AfterReturning("execution(int com.naruto.ssm.aop.calculator.MathCalculator.*(..))")
    public void logReturn() {
        System.out.println("【切面 - 日志】：返回......");
    }

    @Before("args(int,int)")
    public void haha() {
        System.out.println("【切面 - 日志】：haha......");
    }

    // 参数上有没有标注注解
    @Before("@args(com.naruto.ssm.ioc.annotate.UUID_ID) && within(com.naruto.ssm.aop.service.UserService)")
    // 没成功，后续再研究吧
    public void apple() {
        System.out.println("【切面 - 日志】：参数上有没有标注解......");
    }

    // 方法上有没有标注注解
    @Before("@annotation(com.naruto.ssm.ioc.annotate.UUID_ID)")   // 注解是标在实现类的方法上的，不是接口下方法的上面的
    public void banana() {
        System.out.println("【切面 - 日志】：方法上有没有标注注解......");
    }
}
