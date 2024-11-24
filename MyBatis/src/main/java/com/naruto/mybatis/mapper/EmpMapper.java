package com.naruto.mybatis.mapper;

import com.naruto.mybatis.model.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
     * 根据id和name获取员工信息
     *
     * @param id   员工id
     * @param name 员工name
     * @return 员工信息
     */
    Emp getEmpByIdAndName(@Param("id") Integer id, @Param("name") String name);

    // select * from emp where id = #{id} and name = #{从map中取到的name} and age = #{ages取第三个值} and salary = #{e中的salary}
    Emp getEmpHaHa(@Param("id") Integer id,
                   @Param("names") Map<String, String> names,
                   @Param("ages") List<Integer> ages,
                   @Param("e") Emp e);


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
