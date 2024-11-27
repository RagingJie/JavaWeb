package com.naruto.mybatis.mapper;

import com.naruto.mybatis.model.pojo.Customer;
import com.naruto.mybatis.model.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderCustomerStepMapper {

    // 根据客户id查询订单
    List<Order> getOrderByCustomerId(@Param("cId") Integer cId);

    //1、 分步查询：自动做两步 =查询客户+查询客户下的订单
    Customer getCustomerAndOrdersStep(Integer id);

    // 根据客户id查询客户信息
    Customer getCustomerById(Integer id);

    // 2、分布查询：自动做两步 = 按照id查询订单 + 查询订单对应的客户
    Order getOrderAndCustomerStep(Integer id);

}
