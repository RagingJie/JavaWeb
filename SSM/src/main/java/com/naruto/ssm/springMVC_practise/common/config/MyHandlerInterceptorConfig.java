package com.naruto.ssm.springMVC_practise.common.config;

import com.naruto.ssm.springMVC_practise.common.interceptor.MyHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author
 * @Date 2024/11/10 23:43
 * @Description: 拦截器配置
 */
@Configuration
public class MyHandlerInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private MyHandlerInterceptor myHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myHandlerInterceptor)
                .addPathPatterns("/**");  // 拦截所有的请求路径
    }
}
