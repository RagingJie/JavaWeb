package com.naruto.ssm.springMVC_practise.controller;

import com.naruto.ssm.ioc.common.result.AjaxResult;
import com.naruto.ssm.springMVC_practise.pojo.Employee;
import com.naruto.ssm.springMVC_practise.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author
 * @Date 2024/11/9 18:30
 * @Description:
 */

/*
 *
 * 数据校验：
 * 1、导入校验包
 * 2、JavaBean 编写校验注解
 * 3、使用 @Valid 告诉 SpringMVC 进行校验
 * 效果1： 如果校验不通过，目标方法不执行
 * 4【以后不用】、在 @Valid 参数后面，紧跟一个 BindingResult 参数，封装校验结果
 * 效果2： 全局异常处理机制
 * 5【推荐】：编写一个全局异常处理器，处理 MethodArgumentNotValidException（校验出错的异常），统一返回校验失败的提示消息
 * 6：自定义校验 = 自定义校验注解 + 自定义校验器
 *
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
        System.out.println("目标方法执行......");
        List<Employee> list = employeeService.getList();
        return AjaxResult.success(list);
    }

    @PostMapping("/employee")
    public AjaxResult save(@RequestBody @Valid Employee employee/*, BindingResult result*/) {
//        if (!result.hasFieldErrors()) {
        employeeService.save(employee);
        return AjaxResult.success();
/*        } else {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError fieldError : result.getFieldErrors()) {
                errorMap.put(fieldError.getCode(), fieldError.getDefaultMessage());
            }
            return AjaxResult.error("数据校验失败", errorMap);
        }*/
    }

    /**
     * 修改员工
     * 要求：前端发送请求把员工的json放在请求体中； 必须携带id
     *
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
