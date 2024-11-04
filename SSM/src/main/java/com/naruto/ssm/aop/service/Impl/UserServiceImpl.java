package com.naruto.ssm.aop.service.Impl;

import com.naruto.ssm.aop.service.UserService;
import com.naruto.ssm.ioc.annotate.UUID_ID;
import org.springframework.stereotype.Service;

/**
 * @Author
 * @Date 2024/11/4 10:44
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void save(String name) {
        System.out.println("保存名字：" + name);
    }

    @Override
    public void updateUser(int x, int y) {
        System.out.println("哈哈哈哈哈哈.........");
    }

    @Override
    public void getUser(String value, int a) {
        System.out.println("里面有@UUID_ID........" + value);
    }

    @Override
    @UUID_ID
    public void setUser() {
        System.out.println("方法上有@UUID_ID.....");
    }


}
