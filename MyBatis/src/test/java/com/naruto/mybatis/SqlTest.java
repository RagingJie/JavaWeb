package com.naruto.mybatis;


import com.naruto.mybatis.mapper.EmpMapper;
import com.naruto.mybatis.model.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class SqlTest {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void test() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "tom");
        map.put("age", "12");
        Emp emp = new Emp(1, "tom", 12, BigDecimal.valueOf(200.33000));

        List<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(14);
        list.add(18);

        Emp empHaHa = empMapper.getEmpHaHa(1, map, list, emp);
        System.out.println(empHaHa.toString());
    }
}
