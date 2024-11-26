package com.naruto.mybatis;

import com.naruto.mybatis.mapper.OrderMapper;
import com.naruto.mybatis.model.pojo.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void test1(){
        Order order = orderMapper.getOrderAndCustomerById(2);
        System.out.println("订单信息 => "+order);
    }
}
