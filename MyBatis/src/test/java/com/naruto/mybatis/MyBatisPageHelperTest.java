package com.naruto.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.naruto.mybatis.model.pojo.Emp;
import com.naruto.mybatis.service.EmpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPageHelperTest {

    @Autowired
    private EmpService empService;

    @Test
    public void test() {
        /**
         * 原理：拦截器；
         * 原业务底层：select * from emp;
         * 拦截做两件事：
         * 1）、统计这个表的总数量
         * 2）、给原业务底层SQL 动态拼接上 limit 0,5;
         *
         * ThreadLocal： 同一个线程共享数据
         *    1、第一个查询从 ThreadLocal 中获取到共享数据，执行分页
         *    2、第一个执行完会把 ThreadLocal 分页数据删除
         *    3、以后的查询，从 ThreadLocal 中拿不到分页数据，就不会分页
         */
        PageHelper.startPage(10, 10);

        // 紧跟着 startPage 之后 的方法就会执行的 SQL 分页查询
        List<Emp> all = empService.getAll();

        //以后给前端返回它
        PageInfo<Emp> info = new PageInfo<>(all);

        //当前第几页
        System.out.println("当前页码："+info.getPageNum());
        //总页码
        System.out.println("总页码："+info.getPages());
        //总记录
        System.out.println("总记录数："+info.getTotal());
        //有没有下一页
        System.out.println("有没有下一页："+info.isHasNextPage());
        //有没有上一页
        System.out.println("有没有上一页："+info.isHasPreviousPage());
        //本页数据
        System.out.println("本页数据："+info.getList());
    }
}