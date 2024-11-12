package com.naruto.ssm.springMVC_practise.common.annotation;

import com.naruto.ssm.springMVC_practise.common.validator.GenderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @Author
 * @Date 2024/11/11 13:56
 * @Description: 自定义校验性别注解
 */
@Documented
@Constraint(validatedBy = {GenderValidator.class})  // 校验器去真正完成校验功能
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Gender {

    String message() default "{javax.validation.constraints.NotEmpty.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
