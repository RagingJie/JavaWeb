package com.naruto.ssm.springMVC.pojo;

import lombok.Data;

/**
 * @Author
 * @Date 2024/11/6 16:54
 * @Description:
 */
@Data
public class Person {

    // username=zhangsan&password=mima&cellphone=651511&agreement=on

    // username=234234&password=234234&cellphone=234234
    // &address.province=山东省&address.city=济南市&address.area=长清区
    // &sex=男
    // &hobby=足球&hobby=篮球
    // &grade=一年级


    // 用户名
    private String username = "wanglaoji";
    // 密码
    private String password;
    // 手机号
    private String cellphone;
    // 是否同意
    private boolean agreement;
    // 地址
    private Address address;
    // 爱好
    private String[] hobby;
    // 年级
    private String grade;

    @Data
    public static class Address {
        private String province;
        private String city;
        private String area;
    }

}


