package com.naruto.mybatis;

import com.naruto.mybatis.mapper.EmpReturnValueMapper;
import com.naruto.mybatis.model.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ReturnValueTest {

    @Autowired
    EmpReturnValueMapper empReturnValueMapper;

    @Test
    public void testReturnValue() {
        Long count = empReturnValueMapper.getCount();
        System.out.println("员工数量 => " + count);

        BigDecimal salary = empReturnValueMapper.getSalaryById(3);
        System.out.println("3号员工工资 => " + salary);
    }

    @Test
    public void getAll() {
        List<Emp> all = empReturnValueMapper.getAll();
        System.out.println(all);
    }

    @Test
    public void getAllMap() {
        Map<Integer, Emp> allMap = empReturnValueMapper.getAllMap();
        System.out.println("allMap => " + allMap);

        System.out.println(allMap.get(2));

        Emp emp = allMap.get(2);
        System.out.println(allMap.get(2).getClass());
//        System.out.println(emp.getClass());
//        System.out.println(emp.getAge());
    }

    @Test
    public void testEmp() {
        Emp emp = empReturnValueMapper.getEmpById(2);
        System.out.println(emp);
    }
}
