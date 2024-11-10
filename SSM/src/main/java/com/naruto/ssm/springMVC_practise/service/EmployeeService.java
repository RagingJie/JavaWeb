package com.naruto.ssm.springMVC_practise.service;

import com.naruto.ssm.springMVC_practise.pojo.Employee;

import java.util.List;

/**
 * @Author
 * @Date 2024/11/9 18:46
 * @Description:
 */
public interface EmployeeService {

    void save(Employee employee);

    Employee getById(Integer id);

    void deleteById(Integer id);

    void update(Employee employee);

    List<Employee> getList();
}
