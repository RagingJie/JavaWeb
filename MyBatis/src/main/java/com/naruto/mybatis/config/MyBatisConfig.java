package com.naruto.mybatis.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: Naruto
 * @Date: 2022/10/14 09:06
 * @Description: mybatis分页插件配置类
 */
@Configuration
public class MyBatisConfig {

    @Bean
    public PageInterceptor pageInterceptor() {
        // 1、导入分页插件拦截器
        PageInterceptor pageInterceptor = new PageInterceptor();
        // 2、根据需求设置相应的参数
        // ..........
        return pageInterceptor;
    }
}
