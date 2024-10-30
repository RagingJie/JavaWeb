package com.naruto.ssm.ioc.service;

import com.naruto.ssm.ioc.pojo.Dog;
import com.naruto.ssm.ioc.pojo.Person;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author
 * @Date 2024/10/23 1:52
 * @Description:
 */
@Data
@Service
public class UserService {

//    @Qualifier("apple") // @Qualifier精确指定：如果容器中这样的组件存在多个，则使用@Qualifier精确指定组件名

    // 个人理解，用@Qualifier时，通常是有@Primary存在

    @Qualifier("lisi") // 精确指定：如果容器中这样的组件存在多个，且有默认组件@Primary。我们可以使用@Qualifier 切换别的组件
    @Autowired
    Person personOne;  // @Primary一旦存在，改属性名就不能实现组件切换了

    // 面试题：@Resource 和 @Autowired 区别
    // 1、@Resource 和 @Autowired 都是做Bean的注入用的，都可以放在属性上
    // 2、@Resource 具有更强的通用性  因为他是javax包下的  @Autowired是Spring框架中的，离开了Spring框架，@Autowired就没用了

    @Autowired(required = false)
    Dog dog;

//    @Resource
//    Dog dog;
}
