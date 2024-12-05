package com.study.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class UnitTest {

    @Test
    public void contextLoads() {
        log.info("单元测试");
    }
}
