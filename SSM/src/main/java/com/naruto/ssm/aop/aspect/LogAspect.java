package com.naruto.ssm.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

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
@Order(2) //数字越小，优先级越高，数字越大，优先级越低；数字越小，越先执行，就必须套到最外层  // 没有加@Order的时候，默认按组件的字母前后顺序排优先级
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
            @Around: 环绕通知，可以控制目标方法是否执行，修改目标方法参数、执行结果等。

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


    //  增强器链: 切面中的所有通知方法其实就是增强器。他们被组织成一个链路放到集合中。目标方法真正执行前后。
    //  会去增强器链中执行哪些需要提前执行的方法。

    //   AOP 的底层原理：
    //      1、Spring会为每个被切面切入的组件创建代理对象(Spring CGLIB 创建的代理对象，无视接口)。
    //      2、代理对象中保存了切面类里面所有通知方法构成的增强器链。
    //      3、目标方法执行时，会先去执行增强器链中拿到需要提前执行的通知方法去执行

          通知方法的执行顺序:
            1、正常链路: 前置通知->目标方法->返回通知->后置通知
            2、异常链路: 前置通知->目标方法->异常通知->后置通知

    */

    // @Pointcut 注解通常用于方法签名前，该方法没有具体的实现，只是一个标识符，用于描述切点。
    @Pointcut(value = "execution(int com.naruto.ssm.aop.calculator.MathCalculator.*(..))")
    public void pointCut() {
    }

    /**
     * @description 开始日志
     */
    @Before("pointCut()")  // 建议精确的找位置切入
    public void logStart(JoinPoint joinPoint) {
        // 1.拿到方法全签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 方法名
        String methodName = signature.getName();
        // 目标方法传来的参数值
        Object[] args = joinPoint.getArgs();
        System.out.println("【切面 - 日志】：【" + methodName + "】开始；参数：" + Arrays.toString(args));
    }

    /**
     * @description 结束日志
     */
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 方法名
        String methodName = signature.getMethod().getName();
        System.out.println("【切面 - 日志】：【" + methodName + "】后置");
    }

    /**
     * @description 返回日志
     */
    @AfterReturning(value = "pointCut()",
            returning = "obj")  // returning = "obj" 获取目标方法返回值
    public void logReturn(JoinPoint joinPoint, Object obj) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【切面 - 日志】：【" + name + "】返回；返回值：" + obj);
    }

    /**
     * @description 异常日志
     */
    @AfterThrowing(value = "pointCut()",
            throwing = "exception") // throwing = "exception"，获取目标方法抛出的异常
    public void logException(JoinPoint joinPoint, Throwable exception) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【切面 - 日志】:【" + name + "】异常；错误信息：" + exception.getMessage());
    }

    //    @Before("args(int,int)")
    public void haha() {
        System.out.println("【切面 - 日志】：haha......");
    }

    // 参数上有没有标注注解
    @Before("@args(com.naruto.ssm.ioc.annotate.UUID) && within(com.naruto.ssm.aop.service.UserService)")
    // 没成功，后续再研究吧
    public void apple() {
        System.out.println("【切面 - 日志】：参数上有没有标注解......");
    }

    // 方法上有没有标注注解
    @Before("@annotation(com.naruto.ssm.ioc.annotate.UUID)")   // 注解是标在实现类的方法上的，不是接口下方法的上面的
    public void banana() {
        System.out.println("【切面 - 日志】：方法上有没有标注注解......");
    }
}
