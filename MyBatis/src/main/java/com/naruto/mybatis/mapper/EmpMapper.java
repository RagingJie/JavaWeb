package com.naruto.mybatis.mapper;

import com.naruto.mybatis.model.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * 根据id获取员工信息
     *
     * @param id 员工id
     * @return 员工信息
     */
    Emp getEmpById(Integer id);

    /**
     * 保存员工信息
     *
     * @param emp 员工信息
     */
    void save(Emp emp);

    /**
     * 根据id删除员工信息
     *
     * @param id 员工id
     */
    void deleteById(Integer id);

    /**
     * 更新员工信息
     *
     * @param emp 员工信息
     */
    void update(Emp emp);

    /**
     * 获取所有员工信息
     *
     * @return 所有员工信息
     */
    List<Emp> getAll();
}
