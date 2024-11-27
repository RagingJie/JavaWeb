package com.naruto.mybatis.mapper;

import com.naruto.mybatis.model.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    Customer getCustomerWithOrdersById(Integer id);

    List<Customer> getAllCustomerWithOrders();
}
