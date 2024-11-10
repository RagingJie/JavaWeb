package com.naruto.ssm.springMVC_practise.controller;

import com.naruto.ssm.ioc.common.result.AjaxResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Author
 * @Date 2024/11/11 0:35
 * @Description:
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public AjaxResult hello(int i) throws FileNotFoundException {
        int a = 5 / i;
//        FileInputStream file = new FileInputStream("D:\\135.md");
        String str = null;
        str.length();

        return AjaxResult.success();
    }

    /*
        异常处理优先级:
            本类 > 精确
            全局 > 模糊

     */

    /**
     * @param e
     * @return com.naruto.ssm.ioc.common.result.AjaxResult
     * @author Naruto
     * @date 2024/11/11 0:44
     * 如果Controller本类出现异常，会自动在本类中找有没有@ExceptionHandler标注的方法
     * 如果有，执行这个方法，它的返回值，就是客户端收到的结果
     */
    @ExceptionHandler(ArithmeticException.class)
    private AjaxResult handlerArithmeticException(ArithmeticException e) {
        System.out.println("处理数学计算异常 => " + e.getMessage());
        return AjaxResult.error(100, "处理数学计算异常 => " + e.getMessage());
    }

    @ExceptionHandler(FileNotFoundException.class)
    private AjaxResult handlerFileNotFoundException(FileNotFoundException e) {
        System.out.println("处理文件未找到异常 => " + e.getMessage());
        return AjaxResult.error(300, "处理文件未找到异常 => " + e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    private AjaxResult handlerOtherException(Throwable e) {
        System.out.println("处理其他异常 => " + e.getMessage());
        return AjaxResult.error(500, "处理其他异常 => " + e.getMessage());
    }

}
