package com.naruto.ssm.springMVC_practise.common.enums;

import lombok.Getter;

/**
 * @Author
 * @Date 2024/11/11 9:59
 * @Description:
 */
public enum BizExceptionEnum {

    ID_NULL(80001, "Id为空"),
    ;

    // 异常状态码
    @Getter
    private Integer code;
    // 异常信息
    @Getter
    private String message;

    BizExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

