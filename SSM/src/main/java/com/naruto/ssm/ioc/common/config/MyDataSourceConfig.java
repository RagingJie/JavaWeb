package com.naruto.ssm.ioc.common.config;

import com.naruto.ssm.ioc.datasource.MyDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Author
 * @Date 2024/11/1 1:33
 * @Description:
 */
//@Profile(value = "dev") // 整体激活
@Configuration
public class MyDataSourceConfig {

    // 1、定义环境标识：自定义【dev、test、prod】；默认【default】
    // 2、激活环境标识
    //      明确告诉Spring当前处于什么环境
    //      你要不说是啥环境，就是default环境

    // 利用条件注解，只在某种环境下激活一个组件
    @Profile(value = {"dev"})  // @Profile("环境标识")。当这个环境被激活的时候，才会加入如下组件
    @Bean
    public MyDataSource dev() {
        MyDataSource dataSource = new MyDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/dev");
        dataSource.setUsername("dev_user");
        dataSource.setPassword("dev_pwd");
        return dataSource;
    }

    @Profile(value = {"test", "default"})
    @Bean
    public MyDataSource test() {
        MyDataSource dataSource = new MyDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setUsername("test_user");
        dataSource.setPassword("test_pwd");
        return dataSource;
    }

    @Profile("prod")
    @Bean
    public MyDataSource prod() {
        MyDataSource dataSource = new MyDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/prod");
        dataSource.setUsername("prod_user");
        dataSource.setPassword("prod_pwd");
        return dataSource;
    }

}
