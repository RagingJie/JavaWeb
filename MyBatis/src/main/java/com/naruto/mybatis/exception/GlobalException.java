package com.naruto.mybatis.exception;

import com.naruto.mybatis.model.result.R;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalException extends Throwable {

    private static final long serialVersionUID = 3042686055658047888L;

    @ExceptionHandler(value = Throwable.class)
    public R defaultErrorHandler(Throwable e) throws Exception {
        e.printStackTrace();
        return R.error();
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public R HttpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e){
        e.printStackTrace();
        return R.error("请求方式不支持~");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        e.printStackTrace();
        BindingResult bindingResult = e.getBindingResult();
        HashMap<String, Object> result = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            result.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return R.error(result);
    }

    @ExceptionHandler(value = UnsatisfiedServletRequestParameterException.class)
    public R unsatisfiedServletRequestParameterExceptionHandler(UnsatisfiedServletRequestParameterException e) {
        e.printStackTrace();
        return R.error(e.getMessage());
    }

    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public R HttpMediaTypeNotSupportedExceptionHandler(HttpMediaTypeNotSupportedException e) {
        e.printStackTrace();
        return R.error("请求内容类型不支持~");
    }
}
