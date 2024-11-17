package com.naruto.mybatis.controller;

import com.naruto.mybatis.model.pojo.Emp;
import com.naruto.mybatis.model.result.R;
import com.naruto.mybatis.model.vo.requestVo.AddEmpVo;
import com.naruto.mybatis.model.vo.requestVo.UpdateEmpVo;
import com.naruto.mybatis.service.EmpService;
import com.naruto.mybatis.utils.SeparatorUtil;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice
@CrossOrigin  // 允许跨域
@RestController
@RequestMapping("/api/v1/empInfo")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping(path = "/getAll")
    public R getAllEmp() {
        List<Emp> list = empService.getAll();
        return R.success(list);
    }

    /**
     * 根据员工id查询员工信息
     *
     * @param id 员工id
     * @return 员工信息
     */
    @GetMapping(path = "/getEmpById", params = "id")
    public R getEmpById(@RequestParam("id") Integer id) {
        return R.success(empService.getEmpById(id));
    }

    /**
     * 新增员工
     *
     * @param addEmpVo 员工信息
     * @return
     */
    @PostMapping(path = "/saveEmp", consumes = "application/json")
    public R saveEmp(@RequestBody @Valid AddEmpVo addEmpVo) {
        Emp emp = new Emp();
        BeanUtils.copyProperties(addEmpVo, emp);
        empService.save(emp);
        System.out.println("添加员工信息的id为 => " + emp.getId());
        SeparatorUtil.getSeparator();
        return R.success("保存成功");
    }

    /**
     * 更新员工信息
     *
     * @param updateEmpVo 员工信息
     * @return
     */
    @PutMapping(path = "/updateEmp", consumes = "application/json")
    public R updateEmp(@RequestBody @Valid UpdateEmpVo updateEmpVo) {
        Emp emp = new Emp();
        BeanUtils.copyProperties(updateEmpVo, emp);
        empService.update(emp);
        return R.success("员工信息更新成功");
    }

    /**
     * 根据员工id删除员工信息
     *
     * @param id 员工id
     * @return
     */
    @DeleteMapping(path = "/deleteEmpById", params = "ids")
    public R deleteEmpById(@RequestParam("id") Integer id) {
        empService.delete(id);
        return R.success("员工id为：【" + id + "】信息删除成功");
    }

    @ExceptionHandler(value = UnsatisfiedServletRequestParameterException.class)
    public R unsatisfiedServletRequestParameterExceptionHandler(UnsatisfiedServletRequestParameterException e) {
        return R.error("员工id不能为空~");
    }

}
