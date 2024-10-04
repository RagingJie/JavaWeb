package com.naruto.easyexcel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author
 * @Date 2024/10/4 23:23
 * @Description: 订单实体对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    // 序列化与反序列化凭证
    private static final long serialVersionUID = 4617296927888028263L;

    // 订单id
    private Integer id;
    // 订单编号
    private String orderNumber;
    // 创建时间
    private String createTime;
    // 更新时间
    private String updateTime;
    // 会员id
    private String memberId;
    // 订单金额
    private BigDecimal price;
    // 子订单id
    private Integer kidOrderId;

}
