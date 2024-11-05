package com.naruto.ssm.transaction.service.Impl;

import com.naruto.ssm.transaction.Dao.AccountDao;
import com.naruto.ssm.transaction.Dao.BookDao;
import com.naruto.ssm.transaction.bean.Book;
import com.naruto.ssm.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @Author
 * @Date 2024/11/5 16:11
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private AccountDao accountDao;


    @Override
    @Transactional
    public boolean checkOut(String userName, Integer bookId, Integer bookNum) {
        // 根据书id获取书信息
        Book book = bookDao.getBookById(bookId);
        // 总价
        BigDecimal totalPrice = book.getPrice().multiply(BigDecimal.valueOf(bookNum));
        // 先扣除用户的余额
        accountDao.updateBalanceByUsername(userName, totalPrice);
        // 再扣除书库存
        bookDao.updateBookStock(bookId, bookNum);

        int a = 10 / 0;
        return true;
    }
}
