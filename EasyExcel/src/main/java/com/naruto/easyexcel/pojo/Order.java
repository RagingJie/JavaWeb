package com.naruto.easyexcel.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author
 * @Date 2024/10/4 23:23
 * @Description: 订单实体对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
// 内容行高
@ContentRowHeight(15)
// 表头行高
@HeadRowHeight(25)
// 列宽
@ColumnWidth(25)
// 内容居中显示
@ContentStyle(horizontalAlignment = HorizontalAlignment.CENTER)
// 表头居中
@HeadStyle(horizontalAlignment = HorizontalAlignment.CENTER)
public class Order implements Serializable {

    // 序列化与反序列化凭证
    private static final long serialVersionUID = 4617296927888028263L;

    // 订单id
    @ExcelIgnore
    private Integer id;

    // 订单编号
    @ExcelProperty("订单编号")
    @ColumnWidth(13)
    private String orderNumber;

    // 会员id
    @ColumnWidth(12)
    @ExcelProperty("会员id")
    private String memberId;

    // 订单金额
    @ColumnWidth(12)
    @ExcelProperty("订单金额")
    private BigDecimal price;

    // 子订单id
    @ExcelIgnore
    @ColumnWidth(8)
    @ExcelProperty("子订单id")
    private Integer kidOrderId;

    // 创建时间
    @ColumnWidth(22)
    @ExcelProperty("创建时间")
    private Date createTime;

    // 更新时间
    @ColumnWidth(22)
    @ExcelProperty("更新时间")
    private Date updateTime;

    // 退款时间
    @ExcelProperty("退款时间")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private String refundTime;

}
