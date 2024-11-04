package com.naruto.ssm.ioc.annotate;

import java.lang.annotation.*;

/**
 * @Author
 * @Date 2024/11/2 1:14
 * @Description:
 */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})  // 作用的目标位置
@Retention(RetentionPolicy.RUNTIME)   // 保留状态
@Documented  // 生成javaDoc文档时，可以在文档中显示
public @interface UUID {

    String value() default "";
}
