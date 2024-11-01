package com.naruto.ssm.ioc.service;

import lombok.ToString;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @Author
 * @Date 2024/10/31 17:24
 * @Description: Aware感知接口的实现
 */
@ToString
@Service
public class AwareService implements EnvironmentAware, BeanNameAware {

    // 环境变量
    private Environment environment;
    // 名字
    private String name;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    /**
     * @return java.lang.String
     * @author Naruto
     * @date 2024/10/31 17:30
     * @description 获取系统类型
     */
    public String getOsType() {
        return environment.getProperty("OS");
    }

    /**
     * @return java.lang.String
     * @author Naruto
     * @date 2024/10/31 17:31
     * @description 获取Bean名字
     */
    public String getBeanName() {
        return this.name;
    }
}
