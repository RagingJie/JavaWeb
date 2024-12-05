package com.study.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class LogTest {

    // 获取日志记录器
//    Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void testLog() {

        // 级别：由低到高：ALL--TRACE--DEBUG--INFO--WARN--ERROR -- OFF
        // 越打印，越粗糙；日志有一个默认级别(INF0)；只会打印这个级别之上的所有信息；

        // 记录日志
        log.trace("追踪日志......");
        log.debug("调试日志.......");
        log.info("信息日志.......");
        log.warn("警告日志.......");
        log.error("错误日志.......");

        //格式: 时间 级别 进程id --- 项目名 --- 线程名 --- 当前类名：日志内容

    }

    @Test
    public void testLog2() throws InterruptedException {
        int a = 10;
        while (true) {
            log.info("信息日志........ok=【{}】========= demo：{}", "哈哈", a++);
            Thread.sleep(3);
        }
    }
}
