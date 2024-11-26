package com.naruto.mybatis.mapper;

import com.naruto.mybatis.model.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    Order getOrderAndCustomerById(Integer id);
}
