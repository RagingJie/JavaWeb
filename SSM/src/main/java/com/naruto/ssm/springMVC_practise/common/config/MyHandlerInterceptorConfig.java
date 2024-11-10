package com.naruto.ssm.springMVC_practise.common.config;

import com.naruto.ssm.springMVC_practise.common.interceptor.MyHandlerInterceptor0;
import com.naruto.ssm.springMVC_practise.common.interceptor.MyHandlerInterceptor1;
import com.naruto.ssm.springMVC_practise.common.interceptor.MyHandlerInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author
 * @Date 2024/11/10 23:43
 * @Description: 拦截器配置
 */

/*

    1、容器中需要有这样一个组件:【WebMvcConfigurer】
        1)、@Bean 放一个 WebMvcConfigurer
        2)、配置类实现 WebMvcConfigurer

 */
@Configuration
public class MyHandlerInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private MyHandlerInterceptor0 myHandlerInterceptor0;

    @Autowired
    private MyHandlerInterceptor1 myHandlerInterceptor1;

    @Autowired
    private MyHandlerInterceptor2 myHandlerInterceptor2;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(myHandlerInterceptor0)
                .addPathPatterns("/**");  // 拦截所有的请求路径

        registry.addInterceptor(myHandlerInterceptor1)
                .addPathPatterns("/**");

        registry.addInterceptor(myHandlerInterceptor2)
                .addPathPatterns("/**");

    }
}
