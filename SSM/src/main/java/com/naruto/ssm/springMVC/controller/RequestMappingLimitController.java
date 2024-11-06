package com.naruto.ssm.springMVC.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author
 * @Date 2024/11/6 14:35
 * @Description:
 */
@RestController  // 相当于 @Controller + @ResponseBody
public class RequestMappingLimitController {


    // 常用的请求方式：GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
    @RequestMapping(path = "/test01", method = {RequestMethod.DELETE, RequestMethod.PUT})
    public String test01() {
        return "限定请求方式......method";
    }

    // http://localhost:8848/test02?username=15&age=19&sex=2

    /**
     * @return java.lang.String
     * @author Naruto
     * @date 2024/11/6 15:01
     * @description
     *
     * 请求参数: params = {"username", "age=19", "sex!=1"}
     * 1)、username:表示请求必须包含 username 参数
     * 2)、age=19:表示请求参数中必须包含 age=19 的参数
     * 3)、sex!=1:表示请求参数中不能包含 sex=1 的参数
     */
    @RequestMapping(value = "/test02", method = RequestMethod.GET, params = {"username", "age=19", "sex!=1"})
    public String test02() {
        return "限定请求参数.......params";
    }


    /**
     * @return java.lang.String
     * @author Naruto
     * @date 2024/11/6 15:19
     * @description
     *
     *
     * 请求头：headers ={"ha"}
     * 1)、ha：表示请求中必须包含名为ha的请求头
     * 2)、hehe!=1：表示请求头中 的 hehe 不能是1;（hehe=0，不带hehe）
     */
    @RequestMapping(value = "/test03", headers = {"ha","he!=1"})
    public String test03(){
        return "限定请求头.......headers";
    }

    /**
     * @return java.lang.String
     * @author Naruto
     * @date 2024/11/6 15:25
     * @description
     *
     * Media Type： 媒体类型
     *
     * 请求内容类型：consumes = {"application/json"}  消费什么数据
     * Media Type：媒体类型
     * 1)、application/json：表示浏览器必须携带json格式的数据。
     */
//    @RequestMapping(value = "/test04", consumes = {"application/json; charset=utf-8"})
    @RequestMapping(value = "/test04", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String test04(){
        return "限定请求内容类型.......consumes";
    }

    /**
     * @return null
     * @author Naruto
     * @date 2024/11/6 15:34
     * @description
     *
     * 响应内容类型：  生产什么数据;
     * produces = {"text/plain;charset=utf-8"};  // 文本类型
     * produces = {"text/html;charset=utf-8"};   // 表单类型 html
     */
    @RequestMapping(value = "/test05", produces = {"text/html;charset=utf-8"})
    public String test05(){
        return "<h1>限定响应内容类型.......produces</h1>";
    }

}
