package com.naruto.ssm.springMVC_RESTful.service.Impl;

import com.naruto.ssm.springMVC_RESTful.dao.EmployeeDao;
import com.naruto.ssm.springMVC_RESTful.pojo.Employee;
import com.naruto.ssm.springMVC_RESTful.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author
 * @Date 2024/11/9 19:00
 * @Description:
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public Employee getById(Integer id) {
        return employeeDao.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        employeeDao.deleteById(id);
    }

    @Override
    public void update(Employee employee) {

        if (employee.getId() == null) return;

        // 1、查询出员工原有信息
        Employee employeeTemp = employeeDao.getById(employee.getId());
        // 2、为空的参数，保留原值
        // 姓名
        if (StringUtils.hasText(employee.getName())) {
            employeeTemp.setName(employee.getName());
        }
        // 地址
        if (StringUtils.hasText(employee.getAddress())) {
            employeeTemp.setAddress(employee.getAddress());
        }
        // 年龄
        if (employee.getAge() != null) {
            employeeTemp.setAge(employee.getAge());
        }
        // 邮箱
        if (StringUtils.hasText(employee.getEmail())) {
            employeeTemp.setEmail(employee.getEmail());
        }
        // 性别
        if (StringUtils.hasText(employee.getGender())) {
            employeeTemp.setGender(employee.getGender());
        }
        // 薪资
        if (employee.getSalary() != null) {
            employeeTemp.setSalary(employee.getSalary());
        }
        employeeDao.update(employeeTemp);
    }

    @Override
    public List<Employee> getList() {
        return employeeDao.getList();
    }
}
