package com.naruto.mybatis;

import com.naruto.mybatis.service.EmpDynamicSQLService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MultiLevelCacheTest {

    @Autowired
    private EmpDynamicSQLService empDynamicSQLService;

    @Test
    public void testMultiLevelCache(){
        empDynamicSQLService.find();
    }
}
