package com.naruto.ssm.transaction.service.Impl;

import com.naruto.ssm.transaction.Dao.AccountDao;
import com.naruto.ssm.transaction.Dao.BookDao;
import com.naruto.ssm.transaction.bean.Book;
import com.naruto.ssm.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
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

    /*
        事务细节:
        1、transactionManager：事务管理器；控制事务的获取、提交、回滚
            底层默认使用哪个事务管理器？默认使用 JdbcTransactionManager;
            原理:
                1、事务管理器：TransactionManager；控制提交和回滚
                2、事务拦截器：TransactionInterceptor: 控制何时提交和回滚
                    completeTransactionAfterThrowing(txInfo，ex)； 在这个时候回滚
                    commitTransactionAfterReturning(txInfo)； 在这个时候提交
        2、propagation：传播行为
        3、isolation：隔离级别
        4、timeout（同 timeoutString）：超时时间；事务超时，以秒为单位
                一旦超过约定时间，事务就会回滚。
                【超时时间】是指：从【方法开始】，到【最后一次数据库操作】结束的时间。
        5、readOnly：只读优化，若一个事务中，只涉及查询操作，可以使用此属性，优化查询速度
        6、rollbackFor（同 rollbackForClassName = "全类名"）：指定哪些异常需要回滚，不是所有异常都一定引起事务回滚
            异常:
                运行时异常（unchecked exception【非受检异常】）
                编译时异常（checked exception【受检异常】）
            【回滚的默认机制】
                运行时异常：回滚
                编译时异常：不回滚

            【可以指定哪些异常需要回滚】
            【回滚 = 运行时异常 + 指定回滚异常】

        7、noRollbackFor（同 noRollbackForClassName ="全类名"）：指明哪些异常不需要回滚。
            【不回滚 = 编译时异常 + 指定不回滚异常】
    */
    @Override
    @Transactional(timeout = 5, rollbackFor = Exception.class)  // 只要遇到异常，事务就回滚
//    @Transactional(noRollbackFor = ArithmeticException.class)  // 遇到指定的异常，事务不回滚
    public boolean checkOut(String userName, Integer bookId, Integer bookNum) throws Exception {
        // 根据书id获取书信息
        Book book = bookDao.getBookById(bookId);
        // 总价
        BigDecimal totalPrice = book.getPrice().multiply(BigDecimal.valueOf(bookNum));
        // 先扣除用户的余额
        accountDao.updateBalanceByUsername(userName, totalPrice);

        // Thread.sleep(3000);   // 体验事务超时用的

        // 再扣除书库存
        bookDao.updateBookStock(bookId, bookNum);

        int a = 10 / 0;
//        FileInputStream fis = new FileInputStream("D:/ad/da.txt"); // 默认情况下，不是所有的异常都会使事务回滚
        return true;
    }
}
