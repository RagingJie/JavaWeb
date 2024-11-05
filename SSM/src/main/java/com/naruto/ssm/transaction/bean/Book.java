package com.naruto.ssm.transaction.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author
 * @Date 2024/11/5 15:01
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    // 主键id
    private int id;
    // 书名
    private String bookName;
    // 价格
    private BigDecimal price;
    // 库存
    private int stock;
}
