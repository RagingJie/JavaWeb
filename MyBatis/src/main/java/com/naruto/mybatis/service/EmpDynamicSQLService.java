package com.naruto.mybatis.service;

import com.naruto.mybatis.model.pojo.Emp;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmpDynamicSQLService {

    @Transactional
    void addEmps(List<Emp> emps);
}
