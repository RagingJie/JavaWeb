package com.naruto.ssm.springMVC.controller;

import com.naruto.ssm.springMVC.pojo.Person;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.net.URLEncoder;

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
    public Person test01() {
        Person person = new Person();
        person.setUsername("admin666");
        person.setPassword("1224554aag15");
        person.setAgreement(true);
        person.setCellphone("1586666666");
        person.setGrade("九年级");
        person.setHobby(new String[]{"打篮球", "踢足球", "打游戏"});
        return person;
    }

    @RequestMapping(value = "/download1")
    public ResponseEntity<byte[]> download1() throws IOException {

        // 获取文件输入流
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\Naruto\\Desktop\\图片\\头像.jpg"));

        // 获取文件的完整的字节数组，一口气读会溢出
        byte[] bytes = fis.readAllBytes();

        // 文件中文名会乱码
        // 解决乱码问题
        String fileName = URLEncoder.encode("头像.jpg", "utf-8");

        return ResponseEntity.ok()
                // 内容大小
                .contentLength(bytes.length)
                // 内容类型：流
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                // 请求头里放入内容处理方式， Content-Disposition：内容处理方式
                .header("Content-Disposition", "attachment;filename=" + fileName)
                // 响应体
                .body(bytes);
    }

    /**
     * @return org.springframework.http.ResponseEntity<org.springframework.core.io.InputStreamResource>
     * @author Naruto
     * @date 2024/11/7 23:46
     * @description 最正规的下载文件方式，固定格式
     */
    @RequestMapping(value = "/download")
    public ResponseEntity<InputStreamResource> download() throws IOException {

        // 获取文件输入流
        FileInputStream fis = new FileInputStream(new File("D:\\BaiduNetdiskDownload\\测试下载.zip"));

        // 1、文件中文名会乱码
        // 解决乱码问题
        String fileName = URLEncoder.encode("下载项目.zip", "utf-8");
        // 2、一次传输的文件过大会导致oom（内存溢出），采用InputStreamResource
        InputStreamResource resource = new InputStreamResource(fis);

        return ResponseEntity.ok()
                // 内容大小
                .contentLength(fis.available())
                // 内容类型：流
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                // 请求头里放入内容处理方式， Content-Disposition：内容处理方式
                .header("Content-Disposition", "attachment;filename=" + fileName)
                // 响应体
                .body(resource);
    }
}
