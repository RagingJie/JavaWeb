package com.naruto.ssm.springMVC_RESTful.controller;

import com.naruto.ssm.ioc.common.result.AjaxResult;
import com.naruto.ssm.springMVC_RESTful.pojo.Employee;
import com.naruto.ssm.springMVC_RESTful.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * CORS policy：同源策略（限制ajax请求，图片，css，js）； 跨域问题
 * 跨源资源共享（CORS）（Cross-Origin Resource Sharing）
 *    浏览器为了安全，默认会遵循同源策略（请求要去的服务器和当前项目所在的服务器必须是同一个源[同一个服务器]），如果不是，请求就会被拦截
 *    复杂的跨域请求会发送2次：
 *    1、options 请求：预检请求。浏览器会先发送options请求，询问服务器是否允许当前域名进行跨域访问
 *    2、真正的请求：POST、DELETE、PUT等
 *
 *
 * 浏览器页面所在的：http://localhost   /employee/base
 * 页面上要发去的请求：http://localhost:8080   /api/v1/employees
 *  /以前的东西，必须完全一样，一个字母不一样都不行。浏览器才能把请求（ajax）发出去。
 *
 *  跨域问题：
 *    1、前端自己解决：
 *    2、后端解决：允许前端跨域即可 @CrossOrigin
 *          原理：服务器给浏览器的响应头中添加字段：Access-Control-Allow-Origin = *
 *
 */



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
