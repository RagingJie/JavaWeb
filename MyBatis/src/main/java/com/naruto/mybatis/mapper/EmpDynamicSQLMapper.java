package com.naruto.mybatis.mapper;

import com.naruto.mybatis.model.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface EmpDynamicSQLMapper {

    List<Emp> getEmpByNameAndSalary(@Param("name") String name, @Param("salary") BigDecimal salary);

    List<Emp> getEmpByNameAndSalaryAndAge(@Param("name") String name, @Param("salary") BigDecimal salary, @Param("age") Integer age);

    void updateEmp(Emp emp);
}
