package com.naruto.ssm.ioc.dao;

import com.naruto.ssm.ioc.pojo.Dog;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @Author
 * @Date 2024/10/31 17:03
 * @Description:
 */
@Data
@Repository
public class UserDao implements Serializable {

    private Dog Husky;

    /**
     * Spring官方推荐：构造器注入
     * @param dog 必须在ioc容器中有
     */
    // Spring 自动去容器中找到 构造器需要的所有参数的组件值
//    public UserDao(Dog dog) {
//        dog.setAttribute("构造器方式，注入ioc容器");
//        this.Husky = dog;
//    }

    /**
     * set方法注入
     * @param dog 必须在ioc容器中有
     */
    @Autowired
    public void setHusky(Dog dog) {
        System.out.println("set方法的方式，将组件注入ioc容器");
        dog.setAttribute("set方法的方式，将组件注入ioc容器");
        this.Husky = dog;
    }
}
