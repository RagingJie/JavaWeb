package com.naruto.ssm.aop.service.Impl;

import com.naruto.ssm.aop.service.UserService;

/**
 * @Author
 * @Date 2024/11/4 10:44
 * @Description:
 */
public class UserServiceImpl implements UserService {

    @Override
    public void save(String name) {
        System.out.println("保存名字：" + name);
    }

}
