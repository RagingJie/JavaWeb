package com.naruto.ssm.transaction.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @Author
 * @Date 2024/11/5 15:05
 * @Description:
 */
@Component
public class AccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * @param username 用户名
     * @param priceNum 扣减金额数
     * @return void
     * @author Naruto
     * @date 2024/11/5 15:59
     * @description 根据用户名扣减用户余额
     */
    public void updateBalanceByUsername(String username, BigDecimal priceNum) {
        // sql
        String sql = "update account set balance = balance - ? where username = ?";
        try {
            // 执行sql
            jdbcTemplate.update(sql, priceNum, username);
        } catch (DataAccessException e) {
            System.out.println("扣减用户余额时，发生的错误信息：" + e.getCause());
        }
    }

}
