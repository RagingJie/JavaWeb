package com.naruto.mybatis;

import com.naruto.mybatis.mapper.EmpDynamicSQLMapper;
import com.naruto.mybatis.model.pojo.Emp;
import com.naruto.mybatis.service.EmpDynamicSQLService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DynamicSQLTest {

    @Autowired
    private EmpDynamicSQLMapper empDynamicSQLMapper;
    @Autowired
    private EmpDynamicSQLService empDynamicSQLService;

    /**
     * 测试批量操作，事务回滚
     */
    @Test
    public void testDynamicSQL() {
        ArrayList<Emp> emps = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Emp emp = new Emp();
            emp.setAge(3 + i);
            emp.setEmpName("测试" + i);
            emp.setEmpSalary(BigDecimal.valueOf(249.876));
            emps.add(emp);
        }
        empDynamicSQLService.addEmps(emps);
    }

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

    @Test
    public void testDynamicSQL6() {
        ArrayList<Emp> emps = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Emp emp = new Emp();
            emp.setAge(3 + i);
            emp.setEmpName("测试" + i);
            emp.setEmpSalary(BigDecimal.valueOf(249.876));
            emps.add(emp);
        }
        empDynamicSQLMapper.addEmps(emps);
    }


    @Test
    public void testDynamicSQL7() {
        ArrayList<Emp> emps = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Emp emp = new Emp();
            emp.setAge(5 + i);
            emp.setId(i + 10);
            emp.setEmpName("王" + i);
            emp.setEmpSalary(BigDecimal.valueOf(245.5 + i * 2));
            emps.add(emp);
        }

        empDynamicSQLMapper.updateEmps(emps);
    }
}
