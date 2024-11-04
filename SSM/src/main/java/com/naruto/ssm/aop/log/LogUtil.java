package com.naruto.ssm.aop.log;

import java.util.Arrays;

/**
 * @Author
 * @Date 2024/11/4 10:52
 * @Description:
 */
// 日志工具类
public class LogUtil {

    /**
     * @param name 方法名
     * @param args 方法传入的参数
     * @return void
     * @author Naruto
     * @date 2024/11/4 10:54
     * @description 开始日志
     */
    public static void logStart(String name, Object[] args) {
        System.out.println("【日志】：【" + name + "】开始；参数：" + Arrays.toString(args));
    }

    /**
     * @param name 方法名
     * @return void
     * @author Naruto
     * @date 2024/11/4 10:54
     * @description 结束日志
     */
    public static void logEnd(String name) {
        System.out.println("【日志】：【" + name + "】结束；");
    }

    /**
     * @param name 方法名
     * @param e    异常
     * @return void
     * @author Naruto
     * @date 2024/11/4 10:54
     * @description 异常日志
     */
    public static void logException(String name, Throwable e) {
        System.out.println("【日志】：【" + name + "】异常；异常信息：" + e.getCause());
    }

    /**
     * @param name   方法名
     * @param result 返回结果
     * @return void
     * @author Naruto
     * @date 2024/11/4 10:54
     * @description 异常日志
     */
    public static void logReturn(String name, Object result) {
        System.out.println("【日志】：【" + name + "】返回；返回值：" + result);
    }


}
