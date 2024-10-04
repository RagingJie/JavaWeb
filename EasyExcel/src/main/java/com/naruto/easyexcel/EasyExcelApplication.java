package com.naruto.easyexcel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EasyExcelApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyExcelApplication.class, args);
        log.info("=========================================================");
        log.info("学习EasyExcel项目Demo启动！！！");
        log.info("=========================================================");
    }

}
