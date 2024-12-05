package com.study.springboot;

import com.study.springboot.service.HelloService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class UnitTest {

    @Autowired
    HelloService helloService;

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

    @DisplayName("断言测试")
    @Test
    public void test1(){
        String result = helloService.sayHello();
        log.info(result);

        Assertions.assertEquals("Hello 1", result, "测试中的返回值与预期不一致");
    }
}
