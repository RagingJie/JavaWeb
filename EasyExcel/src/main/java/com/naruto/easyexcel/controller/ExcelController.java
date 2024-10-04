package com.naruto.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.naruto.easyexcel.common.AjaxResult;
import com.naruto.easyexcel.pojo.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Author
 * @Date 2024/10/4 23:41
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/excelController")
public class ExcelController {

    /**
     * @param response 响应
     * @return void
     * @author Naruto
     * @date 2024/10/4 23:47
     * @description 导出文件
     */
    @GetMapping("/download")
    public AjaxResult download(HttpServletResponse response, @RequestParam Integer index) {
        ArrayList<Order> list = new ArrayList<>();
        // 填充数据
        addData(list);
        log.info("请求选项=> {}", index);

        switch (index) {
            case 1:
                one(list);
                log.info("《第一种》最简单的写出方式");
                break;
            default:
                log.error("暂无此选项！");
        }
        return AjaxResult.success();
    }

    /**
     * @param list 订单信息集合
     * @return void
     * @author Naruto
     * @date 2024/10/5 1:22
     * @description 填充数据
     */
    private void addData(ArrayList<Order> list) {
        Order order1 = new Order(1, "order001", "user001", BigDecimal.valueOf(15.6), 1, new Date(), new Date());
        Order order2 = new Order(2, "order002", "user002", BigDecimal.valueOf(156), 2, new Date(), new Date());
        Order order3 = new Order(3, "order003", "user003", BigDecimal.valueOf(12.68), 3, new Date(), new Date());
        Order order4 = new Order(4, "order004", "user004", BigDecimal.valueOf(9.8), 4, new Date(), new Date());
        Order order5 = new Order(5, "order005", "user005", BigDecimal.valueOf(3.1), 5, new Date(), new Date());
        Order order6 = new Order(6, "order006", "user006", BigDecimal.valueOf(10), 6, new Date(), new Date());
        Order order7 = new Order(7, "order007", "user007", BigDecimal.valueOf(25.6), 7, new Date(), new Date());
        Order order8 = new Order(8, "order008", "user008", BigDecimal.valueOf(58.47), 8, new Date(), new Date());
        Order order9 = new Order(9, "order009", "user009", BigDecimal.valueOf(185.47), 9, new Date(), new Date());
        Order order10 = new Order(10, "order010", "user010", BigDecimal.valueOf(1515.57), 10, new Date(), new Date());
        Order order11 = new Order(11, "order011", "user011", BigDecimal.valueOf(15.47), 11, new Date(), new Date());
        Order order12 = new Order(12, "order012", "user012", BigDecimal.valueOf(63.77), 12, new Date(), new Date());
        list.add(order1);
        list.add(order2);
        list.add(order3);
        list.add(order4);
        list.add(order5);
        list.add(order6);
        list.add(order7);
        list.add(order8);
        list.add(order9);
        list.add(order10);
        list.add(order11);
        list.add(order12);
    }

    private void one(ArrayList<Order> list) {
        // 创建一个Excel文件
        String fileName = "EasyExcel/src/main/resources/excelFile/one.xlsx";
        // 向Excel表格中写数据
        EasyExcel.write(fileName, Order.class).sheet("订单信息").doWrite(list);
    }
}
