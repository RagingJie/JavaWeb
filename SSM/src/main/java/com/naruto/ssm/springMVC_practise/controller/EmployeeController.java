package com.naruto.ssm.springMVC_practise.controller;

import com.naruto.ssm.ioc.common.result.AjaxResult;
import com.naruto.ssm.springMVC_practise.common.vo.requestVo.EmployeeAddVo;
import com.naruto.ssm.springMVC_practise.common.vo.requestVo.EmployeeUpdateVo;
import com.naruto.ssm.springMVC_practise.common.vo.responseVo.EmployeeResponseVo;
import com.naruto.ssm.springMVC_practise.pojo.Employee;
import com.naruto.ssm.springMVC_practise.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

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
@Tag(name = "员工管理")
@CrossOrigin  // 允许跨域
@RequestMapping("/api/v1")
@RestController
public class EmployeeController {

    /**
     * 设计模式：单一职责；
     * JavaBean也要分层，各种xxO：
     * Pojo：普通java类
     * Dao：Database Access Object ： 专门用来访问数据库的对象
     * DTO：Data Transfer Object： 专门用来传输数据的对象；
     * TO：transfer Object： 专门用来传输数据的对象；
     * BO：Business Object： 业务对象（Service），专门用来封装业务逻辑的对象；
     * VO：View/Value Object： 值对象，视图对象（专门用来封装前端数据的对象）
     */

    @Autowired
    EmployeeService employeeService;

    @Operation(summary = "根据Id获取员工信息")
    @Parameters(@Parameter(name = "id", required = true, description = "用户id", in = ParameterIn.PATH))
    @GetMapping("/employee/{id}")
    public AjaxResult getEmployee(@PathVariable("id") Integer id) {
        Employee employee = employeeService.getById(id);
        return AjaxResult.success(employee);
    }

    @Operation(summary = "获取所有员工信息")
    @GetMapping("/employees")
    public AjaxResult getAll() {
        System.out.println("目标方法执行......");
        List<Employee> list = employeeService.getList();
        // stream流的方式
        List<EmployeeResponseVo> responseVoList = list.stream().map(item -> {
            EmployeeResponseVo employeeResponseVo = new EmployeeResponseVo();
            BeanUtils.copyProperties(item, employeeResponseVo);
            return employeeResponseVo;
        }).collect(Collectors.toList());
        return AjaxResult.success(responseVoList);
    }

    @Operation(summary = "保存员工信息")
    @PostMapping("/employee")
    public AjaxResult save(@RequestBody @Valid EmployeeAddVo employeeAddVo/*, BindingResult result*/) {
//        if (!result.hasFieldErrors()) {
        Employee employee = new Employee();
        // 属性对拷
        BeanUtils.copyProperties(employeeAddVo, employee);
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
     * @param employeeUpdateVo
     * @return
     */
    @Operation(summary = "更新员工信息")
    @PutMapping("/employee")
    public AjaxResult update(@RequestBody @Valid EmployeeUpdateVo employeeUpdateVo) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeUpdateVo, employee);
        employeeService.update(employee);
        return AjaxResult.success();
    }

    @Operation(summary = "根据id删除员工信息")
    @Parameters(@Parameter(name = "id", description = "用户id", required = true, in = ParameterIn.PATH))
    @DeleteMapping("/employee/{id}")
    public AjaxResult delete(@PathVariable("id") Integer id) {
        employeeService.deleteById(id);
        return AjaxResult.success();
    }
}
