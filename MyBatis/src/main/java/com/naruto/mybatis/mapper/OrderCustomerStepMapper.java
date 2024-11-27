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

    // 【超级分布】案例3：按照id查询订单 以及 下单的客户 以及 客户的所有订单
    // 若是按照这个查询顺序  订单 -> 客户 -> 订单 -> 客户   这样的查询会陷入死循环，程序会报 StackOverflowError 堆栈溢出异常
    Order getOrderByIdAndCustomerAndOtherOrderStep(Integer id);

}
