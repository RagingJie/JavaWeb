package com.naruto.mybatis.mapper;

import com.naruto.mybatis.model.pojo.Emp;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpReturnValueMapper {

    Long getCount();

    BigDecimal getSalaryById(Integer id);

    List<Emp> getAll();

    @MapKey("id")  // 实际保存的不是Emp对象，是 HashMap
    Map<Integer, Emp> getAllMap();

    Emp getEmpById(Integer id);
}
