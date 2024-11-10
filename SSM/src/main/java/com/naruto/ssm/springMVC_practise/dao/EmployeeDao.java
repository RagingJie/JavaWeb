package com.naruto.ssm.springMVC_practise.dao;

import com.naruto.ssm.springMVC_practise.pojo.Employee;

import java.util.List;

/**
 * @Author
 * @Date 2024/11/9 21:15
 * @Description:
 */
public interface EmployeeDao {

    void save(Employee employee);

    Employee getById(Integer id);

    void deleteById(Integer id);

    void update(Employee employee);

    List<Employee> getList();
}
