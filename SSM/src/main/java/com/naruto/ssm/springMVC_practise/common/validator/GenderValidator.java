package com.naruto.ssm.springMVC_practise.common.validator;

import com.naruto.ssm.springMVC_practise.common.annotation.Gender;
import com.naruto.ssm.springMVC_practise.pojo.Employee;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author
 * @Date 2024/11/11 13:59
 * @Description: 性别验证器
 */
public class GenderValidator implements ConstraintValidator<Gender, String> {

    /**
     * @param value                      前端提交来的准备让我们进行校验的属性值
     * @param constraintValidatorContext 校验上下文
     * @return boolean
     * @author Naruto
     * @date 2024/11/11 14:03
     * @description
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value.equals("男") || value.equals("女");
    }
}
