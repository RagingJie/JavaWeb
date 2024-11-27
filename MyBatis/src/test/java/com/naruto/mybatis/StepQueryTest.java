package com.naruto.mybatis;

import com.naruto.mybatis.mapper.OrderCustomerStepMapper;
import com.naruto.mybatis.model.pojo.Customer;
import com.naruto.mybatis.model.pojo.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
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

//        Order orderAndCustomerStep = orderCustomerStepMapper.getOrderAndCustomerStep(2);
//        System.out.println(orderAndCustomerStep);

        Order order = orderCustomerStepMapper.getOrderByIdAndCustomerAndOtherOrderStep(1);
        System.out.println("order => " + order);
    }

    // mysql延迟加载：延迟加载，只有查询参数结果的某一个属性或参数时，调用才会加载
    @Test
    public void testStepQuery2() throws InterruptedException {
        Order order = orderCustomerStepMapper.getOrderAndCustomerStep(1);
        System.out.println(order.getAddress());

        System.out.println("=================================");
        System.out.println(order.getAmount());

        Thread.sleep(3000);

        System.out.println("=================================");
        System.out.println(order.getCustomer());

    }
}
