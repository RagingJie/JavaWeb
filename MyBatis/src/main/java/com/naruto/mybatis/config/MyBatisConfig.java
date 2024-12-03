package com.naruto.mybatis.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

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
        // 设置分页合理化参数，默认值为false。当该参数设置为 true 时，pageNum<=0 时会查询第一页， pageNum>pages（超过总数时），会查询最后一页。默认false 时，直接根据参数进行查询
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}
