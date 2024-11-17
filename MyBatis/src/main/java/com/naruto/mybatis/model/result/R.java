package com.naruto.mybatis.model.result;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class R<T> {

    private static final Integer SUCCESS_CODE = 200;
    private static final String SUCCESS_MSG = "success";
    private static final String ERROR_MSG = "error";
    private static final Integer ERROR_CODE = 500;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public static <T> R<T> success() {
        return new R<T>(SUCCESS_CODE, SUCCESS_MSG, null);
    }

    public static <T> R<T> success(T data) {
        return new R<T>(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static <T> R<T> success(String msg, T data) {
        return new R<T>(SUCCESS_CODE, msg, data);
    }

    public static <T> R<T> error() {
        return new R<T>(ERROR_CODE, null, null);
    }

    public static <T> R<T> error(String msg) {
        return new R<T>(ERROR_CODE, msg, null);
    }

    public static <T> R<T> error(T data) {
        return new R<T>(ERROR_CODE, ERROR_MSG, data);
    }

    public static <T> R<T> error(Integer code, String msg) {
        return new R<T>(code, msg, null);
    }

    public static <T> R<T> error(Integer code, String msg, T data) {
        return new R<T>(code, msg, data);
    }

}
