package com.naruto.ssm.springMVC_practise.controller;

import com.naruto.ssm.ioc.common.result.AjaxResult;
import com.naruto.ssm.springMVC_practise.pojo.Employee;
import com.naruto.ssm.springMVC_practise.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2024/11/9 18:30
 * @Description:
 */
@CrossOrigin  // 允许跨域
@RequestMapping("/api/v1")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public AjaxResult getEmployee(@PathVariable("id") Integer id) {
        Employee employee = employeeService.getById(id);
        return AjaxResult.success(employee);
    }

    @GetMapping("/employees")
    public AjaxResult getAll() {
        List<Employee> list = employeeService.getList();
        return AjaxResult.success(list);
    }

    @PostMapping("/employee")
    public AjaxResult save(@RequestBody Employee employee) {
        employeeService.save(employee);
        return AjaxResult.success();
    }

    /**
     * 修改员工
     * 要求：前端发送请求把员工的json放在请求体中； 必须携带id
     * @param employee
     * @return
     */
    @PutMapping("/employee")
    public AjaxResult update(@RequestBody Employee employee) {
        employeeService.update(employee);
        return AjaxResult.success();
    }

    @DeleteMapping("/employee/{id}")
    public AjaxResult delete(@PathVariable("id") Integer id) {
        employeeService.deleteById(id);
        return AjaxResult.success();
    }
}
