package com.study.springboot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LogTest {

    // 获取日志记录器
    Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void testLog() {

        // 级别：由低到高：ALL--TRACE--DEBUG--INFO--WARN--ERROR -- OFF
        // 越打印，越粗糙；日志有一个默认级别(INF0)；只会打印这个级别之上的所有信息；

        // 记录日志
        logger.trace("追踪日志......");
        logger.debug("调试日志.......");
        logger.info("信息日志.......");
        logger.warn("警告日志.......");
        logger.error("错误日志.......");

        //格式: 时间 级别 进程id --- 项目名 --- 线程名 --- 当前类名：日志内容

    }
}
