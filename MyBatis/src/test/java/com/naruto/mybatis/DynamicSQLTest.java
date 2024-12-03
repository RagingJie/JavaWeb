package com.naruto.mybatis;

import com.naruto.mybatis.mapper.EmpDynamicSQLMapper;
import com.naruto.mybatis.model.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    @Test
    public void testDynamicSQL2() {
        Emp emp = new Emp();
        emp.setId(6);
        emp.setEmpName("测试动态sql6666");
        emp.setAge(18);
        emp.setEmpSalary(new BigDecimal(165.85));
        System.out.println("=============================================");
        empDynamicSQLMapper.updateEmp(emp);
    }

    @Test
    public void testDynamicSQL3() {
        List<Emp> list = empDynamicSQLMapper.getEmpByNameAndSalaryAndAge("andy", new BigDecimal(1963.88000), 18);
        list.forEach(System.out::println);
    }

    @Test
    public void testDynamicSQL4() {
        List<Emp> list = empDynamicSQLMapper.getEmpByNameAndSalaryWhen(null, new BigDecimal(1963.88000));
        list.forEach(System.out::println);
    }

    @Test
    public void testDynamicSQL5() {
        ArrayList<Integer> list1 = new ArrayList<>();
        List<Emp> list = empDynamicSQLMapper.getEmpByIds(list1);
        list.forEach(item -> {
            System.out.println(item);
        });
    }
}
