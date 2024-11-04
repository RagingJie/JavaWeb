package com.naruto.ssm.ioc.annotate;

import java.lang.annotation.*;

/**
 * @Author
 * @Date 2024/11/2 1:14
 * @Description:
 */
@Target({ElementType.FIELD})  // 作用的目标位置
@Retention(RetentionPolicy.RUNTIME)   // 保留状态
@Documented
public @interface UUID_ID {

    String value() default "";
}
