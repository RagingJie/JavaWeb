package com.naruto.mybatis.service;

import com.naruto.mybatis.model.pojo.Emp;

import java.util.List;

public interface EmpService {

    /**
     * 根据id查询员工信息
     *
     * @param id 员工id
     * @return 员工信息
     */
    Emp getEmpById(Integer id);

    /**
     * 保存员工信息
     *
     * @param emp
     */
    void save(Emp emp);

    /**
     * 更新员工信息
     *
     * @param emp 员工信息
     */
    void update(Emp emp);

    /**
     * 根据员工id删除员工信息
     *
     * @param id 员工id
     */
    void delete(Integer id);

    /**
     * 获取所有员工信息
     */
    List<Emp> getAll();
}
