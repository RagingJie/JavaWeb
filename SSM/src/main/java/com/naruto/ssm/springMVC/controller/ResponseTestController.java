package com.naruto.ssm.springMVC.controller;

import com.naruto.ssm.springMVC.pojo.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author
 * @Date 2024/11/7 1:11
 * @Description:
 */
@RestController
public class ResponseTestController {

    /**
     * @return com.naruto.ssm.springMVC.pojo.Person
     * @author Naruto
     * @date 2024/11/7 1:12
     * @description 返回一个JSON数据
     */
//    @ResponseBody // 把返回的内容，写到响应体中
    @RequestMapping("/resp01")
    public Person test01(){
        Person person = new Person();
        person.setUsername("admin666");
        person.setPassword("1224554aag15");
        person.setAgreement(true);
        person.setCellphone("1586666666");
        person.setGrade("九年级");
        person.setHobby(new String[]{"打篮球","踢足球","打游戏"});
        return person;
    }
}
