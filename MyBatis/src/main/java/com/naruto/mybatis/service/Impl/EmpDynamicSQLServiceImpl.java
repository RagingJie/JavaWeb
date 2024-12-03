package com.naruto.mybatis.service.Impl;

import com.naruto.mybatis.mapper.EmpDynamicSQLMapper;
import com.naruto.mybatis.model.pojo.Emp;
import com.naruto.mybatis.service.EmpDynamicSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpDynamicSQLServiceImpl implements EmpDynamicSQLService {

    @Autowired
    private EmpDynamicSQLMapper empDynamicSQLMapper;

    // 分布式项目情况下，分布式事务很多不支持多sql批量操作的回滚
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    @Override
    public void addEmps(List<Emp> emps) {
        empDynamicSQLMapper.addEmps(emps);
        System.out.println(234 / 0);
    }
}
