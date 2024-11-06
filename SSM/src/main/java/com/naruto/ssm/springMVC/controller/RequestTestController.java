package com.naruto.ssm.springMVC.controller;

import com.naruto.ssm.springMVC.pojo.Person;
import com.naruto.ssm.util.SeparatorUtil;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Author
 * @Date 2024/11/6 16:20
 * @Description:
 */
@RestController
public class RequestTestController {

    //请求参数： username=zhangsan&password=mima&cellphone=651511&agreement=on
    // 1、没有携带:包装类型自动封装为null，基本类型封装为默认值
    // 2、携带:自动封装

    /**
     * @param username  用户名
     * @param password  密码
     * @param cellphone 手机号
     * @param agreement 是否同意用户协议
     * @return java.lang.String
     * @author Naruto
     * @date 2024/11/6 16:33
     * @description
     */
    @RequestMapping("/handle01")
    public String test01(String username, String password, String cellphone, boolean agreement) {

        System.out.println("用户名 => " + username);
        System.out.println("密码 => " + password);
        System.out.println("手机号 => " + cellphone);
        System.out.println("是否同意用户协议 => " + agreement);

        return "OK";
    }

    /*

    请求参数：username=zhangsan&password=123456&cellphone=1234&agreement=on

    @RequestParam：取出某个参数的值。
    默认一定要携带
        required = false:非必须携带;
        defaultValue ="123456"：默认值，参数可以不带。

    无论请求参数带到了 请求体中还是url?后面，他们都是请求参数。都可以直接用@RequestParam或者同一个变量名获取到

    */
    @RequestMapping("/handle02")
    public String test02(@RequestParam("username") String name,
                         @RequestParam("password") String pwd,
                         @RequestParam(value = "cellphone", defaultValue = "15845125412") String phone,
                         @RequestParam(value = "agreement", required = false) boolean ok) {

        System.out.println("用户名 => " + name);
        System.out.println("密码 => " + pwd);
        System.out.println("手机号 => " + phone);
        System.out.println("是否同意用户协议 => " + ok);

        return "OK";
    }

    /*

    如果目标方法参数是一个 pojo；SpringMVC 会自动把请求参数 和 pojo 属性进行匹配;

    效果:
        1、pojo的所有属性值都是来自于请求参数
        2、如果请求参数没带，封装为null;

    */
    @RequestMapping(value = "/handle03", method = RequestMethod.POST)
    public String test03(Person person) {

        System.out.println(person);

        return "OK";
    }


    /**
     * @param host 主机
     * @param ua   客户端
     * @return java.lang.String
     * @author Naruto
     * @date 2024/11/6 17:09
     * @description
     * @RequestHeader 获取请求头信息
     */
    @RequestMapping(value = "/handle04")
    public String test04(@RequestHeader("host") String host,
                         @RequestHeader("user-agent") String ua) {

        System.out.println("主机 => " + host);
        System.out.println("客户端 => " + ua);

        return "OK ===== " + host + "【" + ua + "】";
    }

    /**
     * @param ha
     * @return java.lang.String
     * @author Naruto
     * @date 2024/11/6 17:13
     * @description
     * @CookieValue 获取cookie的值
     */
    @RequestMapping(value = "/handle05")
    public String test05(@CookieValue(value = "ha", required = false) String ha,
                         @CookieValue(value = "he") String he) {

        System.out.println("cookie的值ha => " + ha);
        System.out.println("cookie的值he => " + he);

        return "OK";
    }

    /**
     * @param person
     * @return java.lang.String
     * @author Naruto
     * @date 2024/11/6 17:26
     * @description
     *
     * pojo级联封装
     */
    @RequestMapping(value = "/handle06")
    public String test06(Person person) {

        System.out.println(person);

        return "OK";
    }

    /**
     * @param person
     * @return java.lang.String
     * @author Naruto
     * @date 2024/11/6 17:41
     * @description
     *
     *
     * @RequestBody: 获取请求体json数据，自动转为person对象
     * 测试接受json数据
     *  1、发出：请求体中是json字符串，不是k=v
     *  2、接受：@RequestBody Person person
     *
     * @RequestBody Person person
     *  1、拿到请求体中的json字符串
     *  2、把json字符串转为person对象
     *
     */
    @RequestMapping(value = "/handle07")
    public String test07(@RequestBody Person person) {

        System.out.println("===【用户名】：" + person.getUsername());
        System.out.println("===【密码】：" + person.getPassword());
        System.out.println("===【联系电话】：" + person.getCellphone());
        System.out.println("===【年级】：" + person.getGrade());
        System.out.println("===【所在地区】：" + person.getAddress().getProvince()+","+person.getAddress().getCity()+","+person.getAddress().getArea());
        System.out.println("===【爱好】：" + Arrays.toString(person.getHobby()));

        return "OK";
    }

    /**
     * @param person
     * @param headerImgFile
     * @param lifeImgFiles
     * @return java.lang.String
     * @author Naruto
     * @date 2024/11/7 0:25
     * @description 文件上传
     *
     * MultipartFile
     * 1、@RequestParam 取出文件项，封装为【MultipartFile】，就可以拿到文件内容
     *
     */
    @RequestMapping(value = "/handle08")
    public String test08(Person person,
                         @RequestParam(value = "headerImg") MultipartFile headerImgFile,
                         @RequestParam(value = "lifeImg") MultipartFile[] lifeImgFiles) throws IOException {

        SeparatorUtil.getSeparator();

        // 用户基本信息
        System.out.println("【用户名】：" + person.getUsername());
        System.out.println("【密码】：" + person.getPassword());
        System.out.println("【联系电话】：" + person.getCellphone());

        // 上文文件方法调用
        String contentType = headerImgFile.getContentType();
        System.out.println("【头像】内容类型=》"+contentType);
        String name = headerImgFile.getName();
        System.out.println("【头像】名字=》"+name);
        String originalFilename = headerImgFile.getOriginalFilename();
        System.out.println("【头像】原始文件名字【有文件后缀名】=》"+originalFilename);
        Resource resource = headerImgFile.getResource();
        System.out.println("【头像】资源=》"+resource);
        long size = headerImgFile.getSize();
        System.out.println("【头像】文件大小=》" + size + "B; 转换KB为=> " + (size / 1024.0) + "KB，转换为MB=> "+  (size / 1024 / 1024.0) +"MB");

        // 转存文件
        headerImgFile.transferTo(new File("D:\\WorkSpace\\JavaWeb\\SSM\\src\\main\\resources\\uploadFile\\image\\"+originalFilename));  // 在练习的时候，只能填写绝对路径，待研究
        System.out.println("====== 头像上传成功 ======");

        for (MultipartFile lifeImgFile : lifeImgFiles) {
            lifeImgFile.transferTo(new File("D:\\WorkSpace\\JavaWeb\\SSM\\src\\main\\resources\\uploadFile\\image\\"+lifeImgFile.getOriginalFilename()));
        }

        System.out.println("====== 文件上传成功 ======");

        SeparatorUtil.getSeparator();

        return "OK";
    }


    /**
     * @param entity 请求体
     *@return java.lang.String
     * @author Naruto
     * @date 2024/11/7 0:52
     * @description 获取封装请求原始数据
     *
     * HttpEntity：分装请求头、请求体
     *      泛型：<Person>：请求体类型
     */
    @RequestMapping(value = "/handle09")
    public String test09(HttpEntity<Person> entity){

        // 获取请求头
        HttpHeaders headers = entity.getHeaders();
        System.out.println("请求头信息 => " + headers);
        System.out.println("客户端信息 => " + headers.get("user-agent"));

        // 获取请求体
        Person body = entity.getBody();
        System.out.println("请求体数据 => " + body);

        return "OK~~";
    }


    /**
     * @param request
     * @param response
     * @return void
     * @author Naruto
     * @date 2024/11/7 0:59
     * @description 获取原生的API
     *
     * 接收原生API
     */
    @RequestMapping("/handle10")
    public void test10(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        System.out.println("获取到的用户名 => "+username);

        Object username1 = request.getAttribute("username");
        System.out.println("获取到的用户名 => "+username1);

        response.getWriter().write(username);
    }

}
