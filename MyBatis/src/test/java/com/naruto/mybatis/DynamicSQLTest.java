package com.naruto.mybatis;

import com.naruto.mybatis.mapper.EmpDynamicSQLMapper;
import com.naruto.mybatis.model.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class DynamicSQLTest {

    @Autowired
    private EmpDynamicSQLMapper empDynamicSQLMapper;

    @Test
    public void testDynamicSQL1() {
        // 1、select * from t_emp where  and emp_salary = ?
        List<Emp> list = empDynamicSQLMapper.getEmpByNameAndSalary("有形的翅膀", new BigDecimal(1963.88000));
//        List<Emp> list = empDynamicSQLMapper.getEmpByNameAndSalary(null, null);
//        List<Emp> list = empDynamicSQLMapper.getEmpByNameAndSalary("andy", null);
        System.out.println("=============================================");
        list.forEach(System.out::println);
    }
}
