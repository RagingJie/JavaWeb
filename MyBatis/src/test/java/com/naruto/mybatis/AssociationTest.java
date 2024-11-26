package com.naruto.mybatis;

import com.naruto.mybatis.mapper.CustomerMapper;
import com.naruto.mybatis.mapper.OrderMapper;
import com.naruto.mybatis.model.pojo.Customer;
import com.naruto.mybatis.model.pojo.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AssociationTest {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void test1(){
        Order order = orderMapper.getOrderAndCustomerById(2);
        System.out.println("订单信息 => "+order);
    }

    @Test
    public void test2(){
        Customer customer = customerMapper.getCustomerWithOrdersById(1);
        System.out.println("客户信息 => "+customer);
    }
}
