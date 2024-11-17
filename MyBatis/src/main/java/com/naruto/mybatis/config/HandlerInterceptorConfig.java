package com.naruto.mybatis.config;

import com.naruto.mybatis.interceptor.RequestUrlHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class HandlerInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private RequestUrlHandlerInterceptor requestUrlHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestUrlHandlerInterceptor).addPathPatterns("/**");
    }
}
