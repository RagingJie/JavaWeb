package com.naruto.ssm.ioc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author
 * @Date 2024/11/4 23:24
 * @Description:
 */
@Component
public class Temp {

    @Autowired
    UserTemp userTemp;

    public void get(){
        System.out.println(userTemp);
    }

}
