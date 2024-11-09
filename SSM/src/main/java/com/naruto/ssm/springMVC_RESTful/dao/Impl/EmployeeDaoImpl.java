package com.naruto.ssm.springMVC_RESTful.dao.Impl;

import com.naruto.ssm.springMVC_RESTful.dao.EmployeeDao;
import com.naruto.ssm.springMVC_RESTful.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author
 * @Date 2024/11/9 21:15
 * @Description:
 */
@Component
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @param employee
     * @return void
     * @author Naruto
     * @date 2024/11/9 21:16
     * @description 保存员工信息
     */
    @Override
    public void save(Employee employee) {
        //插入sql
        String sql = "insert into employee(name,age,email,gender,address,salary) values(?,?,?,?,?,?)";
        // 执行sql
        int row = jdbcTemplate.update(sql,
                employee.getName(),
                employee.getAge(),
                employee.getEmail(),
                employee.getGender(),
                employee.getAddress(),
                employee.getSalary());
        System.out.println("添加成功~，影响行数：" + row);

    }

    /**
     * @param id 员工id
     * @return com.naruto.ssm.springMVC_RESTful.pojo.Employee
     * @author Naruto
     * @date 2024/11/9 21:23
     * @description 根据员工id获取员工信息
     */
    @Override
    public Employee getById(Integer id) {
        String sql = "select * from employee where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
    }

    /**
     * @param id 员工id
     * @return void
     * @author Naruto
     * @date 2024/11/9 21:27
     * @description 根据员工id删除员工信息
     */
    @Override
    public void deleteById(Integer id) {
        String sql = "delete from employee where id = ?";
        int row = jdbcTemplate.update(sql, id);
        System.out.println("删除成功~，影响行数：" + row);

    }

    /**
     * @param employee
     * @return void
     * @author Naruto
     * @date 2024/11/9 21:40
     * @description 更新员工信息
     */
    @Override
    public void update(Employee employee) {
        String sql = "update employee set " +
                "name = ?," +
                "age = ?," +
                "email = ?," +
                "gender = ?," +
                "address = ?," +
                "salary = ? " +
                "where id = ?";
        int row = jdbcTemplate.update(sql,
                employee.getName(),
                employee.getAge(),
                employee.getEmail(),
                employee.getGender(),
                employee.getAddress(),
                employee.getSalary(),
                employee.getId());

        System.out.println("更新成功~，影响行数：" + row);

    }

    /**
     * @return java.util.List<com.naruto.ssm.springMVC_RESTful.pojo.Employee>
     * @author Naruto
     * @date 2024/11/9 21:31
     * @description 获取所有的员工信息
     */
    @Override
    public List<Employee> getList() {
        String sql = "select * from employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }
}
