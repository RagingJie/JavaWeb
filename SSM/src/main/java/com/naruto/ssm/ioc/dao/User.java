package com.naruto.ssm.ioc.dao;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author
 * @Date 2024/10/23 1:53
 * @Description:
 */

//BeanPostProcessor：Bean外挂修改器
@Data
public class User implements InitializingBean, DisposableBean {

    private String username;
    private String password;

    private Car car;

    @Autowired
    public void setCar(Car car) {
        this.car = car;
        System.out.println("【User】 ==> 自动注入setCar......" + car);
    }

    public User() {
        System.out.println("【User】 ==> 构造User......");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("【User】 ==> @PostConstruct...........");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("【User】 ==> @PreDestroy.........");
    }

    public void initUser() {
        System.out.println("【User】 ==> @Bean 初始化.......User");
    }

    public void destroyUser() {
        System.out.println("【User】 ==> @Bean 销毁.......User");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【User】 ==> 【DisposableBean】..... destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【User】 ==> 【InitializingBean】..... afterPropertiesSet");
    }
}
