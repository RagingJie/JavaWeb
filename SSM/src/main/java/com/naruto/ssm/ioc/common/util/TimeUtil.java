package com.naruto.ssm.ioc.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Naruto
 * @Date 2024/10/18 10:30
 * @Description: 时间工具类
 */
public abstract class TimeUtil {

    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * @param format 时间格式（字符串）
     * @param date   时间
     * @return java.lang.String
     * @author Naruto
     * @date 2024/10/18 10:43
     * @description 转换时间格式
     */
    public static String conversionTimeFormat(String format, Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * @return 时间戳
     * @author Naruto
     * @date 2024/10/18 10:31
     * @description 获取当前时间（时间戳）
     */
    public static Long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * @return 当前时间字符串（日期 + 时间）
     * @author Naruto
     * @date 2024/10/18 10:34
     * @description 获取当前时间（日期 + 时间）
     */
    public static String getCurrentTime() {
        return timeFormat.format(new Date());
    }

    /**
     * @return 当前日期字符串
     * @author Naruto
     * @date 2024/10/18 10:34
     * @description 获取当前日期
     */
    public static String getCurrentDay() {
        return dayFormat.format(new Date());
    }

    /**
     * @return 当前时间字符串
     * @author Naruto
     * @date 2024/10/18 10:34
     * @description 获取当前时间
     */
    public static String getCurrentHour() {
        return hourFormat.format(new Date());
    }

}
