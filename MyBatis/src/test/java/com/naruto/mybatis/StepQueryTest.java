package com.naruto.mybatis;

import com.naruto.mybatis.mapper.OrderCustomerStepMapper;
import com.naruto.mybatis.model.pojo.Customer;
import com.naruto.mybatis.model.pojo.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class StepQueryTest {

    @Autowired
    private OrderCustomerStepMapper orderCustomerStepMapper;

    @Test
    public void testStepQuery1() {
//        Customer customerAndOrdersStep = orderCustomerStepMapper.getCustomerAndOrdersStep(1);
//        System.out.println(customerAndOrdersStep);

//        List<Order> orderByCustomerId = orderCustomerStepMapper.getOrderByCustomerId(1);
//        System.out.println(orderByCustomerId);

        Order orderAndCustomerStep = orderCustomerStepMapper.getOrderAndCustomerStep(2);
        System.out.println(orderAndCustomerStep);
    }
}
