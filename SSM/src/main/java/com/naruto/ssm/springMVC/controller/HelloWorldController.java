package com.naruto.ssm.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author
 * @Date 2024/11/6 14:06
 * @Description:
 */
@Controller
public class HelloWorldController {

    /*
        【精确路径】必须全局唯一
        路径位置【通配符】：多个都能匹配上，那就精确优先
            *：匹配任意多个字符〔0~N)；不能匹配多个路径
            **：匹配任意多层路径
            ?：匹配任意单个字符（1)

       【精确程度】：完全匹配 > ? > * > **
    */

    @ResponseBody
    @RequestMapping("/hello")
    public String getHello() {
        return "Hello World；你好~~~~";
    }

    @ResponseBody
    @RequestMapping("/hell?")
    public String getHello01() {
        return "? => 匹配任意单个字符（1)";
    }

    @ResponseBody
    @RequestMapping("/hell*")
    public String getHello02() {
        return "* => 匹配任意多个字符〔0~N)；不能匹配多个路径";
    }

    @ResponseBody
    @RequestMapping("/hello/**")
    public String getHello03() {
        return "** => 匹配任意多层路径";
    }
}
