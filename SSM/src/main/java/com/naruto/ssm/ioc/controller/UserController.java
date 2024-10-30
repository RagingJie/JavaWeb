package com.naruto.ssm.ioc.controller;

import com.naruto.ssm.ioc.pojo.Person;
import com.naruto.ssm.ioc.service.UserService;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * @Author
 * @Date 2024/10/23 1:52
 * @Description:
 */
@Data
@ToString
@Controller
public class UserController {

    /*
        自动装配流程（先按照类型，在按照名称）
        1、按照类型，找到这个组件
            1.0、只有且找到一个，直接注入，名字无所谓  ************************
            1.1、如果找到多个，再按照名称去找；变量名就是名字（新版）
                1.1.1、如果找到，直接注入
                1.1.2、如果找不到，报错
     */
    @Autowired  // 自动装配；原理：Spring调用容器.getBean
    UserService userService;

    @Autowired // ioc容器中，存在多个同样类型的组件时，@Autowired引入后的变量名若ioc容器中找不到对应的组件，就会报错
    UserService abc;

    @Autowired
    List<Person> personList;

    @Autowired
    Map<String,Person> personMap;

    @Autowired
    ApplicationContext applicationContext;
}
