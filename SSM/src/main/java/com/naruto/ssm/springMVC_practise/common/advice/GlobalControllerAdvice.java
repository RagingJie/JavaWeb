package com.naruto.ssm.springMVC_practise.common.advice;

import com.naruto.ssm.ioc.common.result.AjaxResult;
import com.naruto.ssm.springMVC_practise.common.exception.BizException;
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
        e.printStackTrace();
        System.out.println("【全局】 - 数学计算异常处理..........");
        return AjaxResult.error(506, "数学计算异常处理 => " + e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public AjaxResult handlerException(Throwable e) {
        e.printStackTrace();
        System.out.println("【全局】 - 异常处理..........");
        return AjaxResult.error(500, "异常处理 => " + e.getMessage());
    }

    /**
     * @param e
     * @return com.naruto.ssm.ioc.common.result.AjaxResult
     * @author Naruto
     * @date 2024/11/11 10:21
     * @description 自定义异常
     */
    @ExceptionHandler(BizException.class)
    public AjaxResult handlerBizException(BizException e) {
        e.printStackTrace();
        System.out.println("【全局】 - 业务异常处理..........");
        return AjaxResult.error(e.getCode(), e.getMessage());
    }
}
