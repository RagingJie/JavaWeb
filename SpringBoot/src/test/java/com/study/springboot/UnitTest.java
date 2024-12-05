package com.study.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class UnitTest {

    @DisplayName("第一个单元测试")
    @Test
    public void contextLoads() {
        log.info("单元测试");
    }

    @BeforeEach
    public void before(){
    	log.info("在每个单元测试之前执行");
    }

    @AfterEach
    public void after(){
        log.info("在每个单元测试之后执行");
    }

    @BeforeAll
    public static void beforeAll(){
        log.info("在所有单元测试之前执行");
    }

    @Timeout(2L)
    @Test
    public void timeout() throws InterruptedException {
        log.info("超时测试");
        Thread.sleep(4000);
    }
}
