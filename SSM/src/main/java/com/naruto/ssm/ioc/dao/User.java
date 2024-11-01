package com.naruto.ssm.ioc.dao;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author
 * @Date 2024/10/23 1:53
 * @Description:
 */
@Data
public class User implements InitializingBean, DisposableBean {

    private String username;
    private String password;

    private Car car;

    @Autowired
    public void setCar(Car car) {
        this.car = car;
        System.out.println("自动注入setCar......" + car);
    }

    public User() {
        System.out.println("构造User......");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("@PostConstruct...........");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("@PreDestroy.........");
    }

    public void initUser() {
        System.out.println("@Bean 初始化.......User");
    }

    public void destroyUser() {
        System.out.println("@Bean 销毁.......User");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【DisposableBean】..... destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean】..... afterPropertiesSet");
    }
}
