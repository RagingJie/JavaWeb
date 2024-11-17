package com.naruto.mybatis.service.Impl;

import com.naruto.mybatis.mapper.EmpMapper;
import com.naruto.mybatis.model.pojo.Emp;
import com.naruto.mybatis.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    /**
     * 根据员工id查询员工信息
     *
     * @param id 员工id
     * @return 员工信息
     */
    @Override
    public Emp getEmpById(Integer id) {
        return empMapper.getEmpById(id);
    }

    /**
     * 保存员工信息
     *
     * @param emp 员工信息
     */
    @Override
    public void save(Emp emp) {
        empMapper.save(emp);
    }

    /**
     * 更新员工信息
     *
     * @param emp 员工信息
     */
    @Override
    public void update(Emp emp) {
        empMapper.update(emp);
    }

    /**
     * 根据id删除员工信息
     *
     * @param id 员工id
     */
    @Override
    public void delete(Integer id) {
        empMapper.deleteById(id);
    }


}
