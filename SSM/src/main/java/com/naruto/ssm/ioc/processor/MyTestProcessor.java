package com.naruto.ssm.ioc.processor;

import com.naruto.ssm.ioc.dao.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author
 * @Date 2024/11/2 0:29
 * @Description:
 */
@Component  // 拦截所有Bean的后置处理器
public class MyTestProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【postProcessAfterInitialization】：" + beanName);
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【postProcessBeforeInitialization】：" + beanName);
        if (bean instanceof User) {
            User user = (User) bean;
            user.setUsername("admin666");
        }
        return bean;
    }
}
