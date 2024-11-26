package com.naruto.mybatis.mapper;

import com.naruto.mybatis.model.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {

    Customer getCustomerWithOrdersById(Integer id);
}
