package com.naruto.mybatis;

import com.naruto.mybatis.mapper.EmpMapper;
import com.naruto.mybatis.model.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyBatisApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    void contextLoads() {
        Emp emp = empMapper.getEmpById(3);
        System.out.println("员工信息 => " + emp);
    }

}
