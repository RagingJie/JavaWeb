package com.naruto.mybatis.service.Impl;

import com.naruto.mybatis.mapper.EmpDynamicSQLMapper;
import com.naruto.mybatis.model.pojo.Emp;
import com.naruto.mybatis.service.EmpDynamicSQLService;
import com.naruto.mybatis.utils.SeparatorUtil;
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

    /**
     * 一级缓存：默认事务期间，会开启事务级别缓存；
     * 1、同一个事务期间，前面查询的数据，后面如果再要执行相同查询，会从一级缓存中获取数据，不会给数据库发送SQL
     * 二级缓存：
     * 多级缓存机制？
     */
    @Transactional
    public void find() {
        Emp empById = empDynamicSQLMapper.getEmpById(1);
        System.out.println(empById);
        SeparatorUtil.getSeparator();

        // 有时候缓存会失效（缓存不命中）。
        // 失效几种情况
        // 1、查询的东西不一样。
        // 2、两次查询之间，进行了一次增删改（由于增删改会引起数据库变化，Mybatis认为，数据有可能变了，它就要再发一次查询）
        empDynamicSQLMapper.updateEmp(empById);
        SeparatorUtil.getSeparator();

        Emp empById1 = empDynamicSQLMapper.getEmpById(1);
        System.out.println(empById1);
    }
}
