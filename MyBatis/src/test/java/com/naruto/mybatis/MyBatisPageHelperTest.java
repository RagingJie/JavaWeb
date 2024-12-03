package com.naruto.mybatis;

import com.github.pagehelper.PageHelper;
import com.naruto.mybatis.model.pojo.Emp;
import com.naruto.mybatis.service.EmpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPageHelperTest {

    @Autowired
    private EmpService empService;

    @Test
    public void test() {
        PageHelper.startPage(10, 5);
        List<Emp> all = empService.getAll();
        all.forEach(System.out::println);
    }
}
