package com.naruto.ssm.springMVC_practise.common.advice;

import com.naruto.ssm.ioc.common.result.AjaxResult;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * @Date 2024/11/11 1:00
 * @Description: 全局异常处理
 */
@RestControllerAdvice   // @ResponseBody + @ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ArithmeticException.class)
    public AjaxResult handlerArithmeticException(ArithmeticException e) {
        System.out.println("【全局】 - 数学计算异常处理..........");
        return AjaxResult.error(506, "数学计算异常处理 => " + e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public AjaxResult handlerException(Throwable e) {
        System.out.println("【全局】 - 异常处理..........");
        return AjaxResult.error(500, "异常处理 => " + e.getMessage());
    }
}
