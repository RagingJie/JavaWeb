package com.naruto.easyexcel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author
 * @Date 2024/10/4 23:41
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/excelController")
public class ExcelController {

    /**
     * @param response 响应
     * @return void
     * @author Naruto
     * @date 2024/10/4 23:47
     * @description 导出文件
     */
    @GetMapping("/download")
    public void download(HttpServletResponse response) {

    }
}
