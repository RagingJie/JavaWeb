package com.naruto.ssm.aop.service;

import com.naruto.ssm.ioc.annotate.UUID_ID;

/**
 * @Author
 * @Date 2024/11/4 10:43
 * @Description:
 */
public interface UserService {

    void save(String name);

    void updateUser(int x, int y);

    void getUser(@UUID_ID String value, int a);

    void setUser();
}
