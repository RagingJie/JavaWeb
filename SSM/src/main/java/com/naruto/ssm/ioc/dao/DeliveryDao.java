package com.naruto.ssm.ioc.dao;

import com.naruto.ssm.ioc.datasource.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.AdjustmentEvent;

/**
 * @Author
 * @Date 2024/11/1 1:37
 * @Description:
 */
@Component
public class DeliveryDao {

    /*
        问题1：数据源组件有三个
            1.@Primary：dev
        效果：能不能启动
            1.告诉Spring，哪个数据源哪种情况下才生效。@Contional
    */
    @Autowired
    MyDataSource myDataSource;

    public void saveDeliveryDao() {
        System.out.println("数据源：保存数据" + myDataSource);
    }
}
