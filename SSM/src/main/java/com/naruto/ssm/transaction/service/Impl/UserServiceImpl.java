package com.naruto.ssm.transaction.service.Impl;

import com.naruto.ssm.transaction.Dao.AccountDao;
import com.naruto.ssm.transaction.Dao.BookDao;
import com.naruto.ssm.transaction.bean.Book;
import com.naruto.ssm.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
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
                读未提交：Isolation.READ_UNCOMMITTED
                读已提交：Isolation.READ_COMMITTED ======= 【当前读】Oracle默认的事务隔离级别
                可重复读：Isolation.REPEATABLE_READ ====== 【快照读】 MySQl默认的事务隔离级别
                串行化：Isolation.SERIALIZABLE
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


    /*
     * 场景：用户结账，炸了以后，金额扣减回滚，库存不回滚。
     * 注意：【一定关注异常的传播链】
     * 实现：
     *    checkout(){
     *        //自己的操作；
     *        扣减金额： //REQUIRED
     *        扣减库存： //REQUIRES_NEW
     *    }
     */

    /*
     * 【事务传播】例题：好好钻研 *********
     *  A {
     *      B(){  //REQUIRED
     *          F();//REQUIRES_NEW
     *          G();//REQUIRED
     *          H();//REQUIRES_NEW
     *      }
     *      C(){  //REQUIRES_NEW
     *         I();//REQUIRES_NEW
     *         J();//REQUIRED
     *      }
     *      D(){   //REQUIRES_NEW
     *          K();//REQUIRES_NEW
     *          L();//REQUIRES_NEW //点位2： 10/0； K,F,H,C(i,j) = ok, E整个代码走不到，剩下炸
     *      }
     *      E(){   //REQUIRED
     *          M();//REQUIRED
     *          //点位3：10/0；  F,H,C(i,j),D(K,L)= ok
     *          N();//REQUIRES_NEW
     *      }
     *
     *      int i = 10/0;  //点位1：C（I，J）,D(K，L) ，F，H,N= ok
     *  }
     *
     */

    // 【传播行为】：参数设置项也会传播：如果小事务和大事务公用一个事务，小事务要按照大事务的设置，小事务自己的设置失效


    @Override
//    @Transactional(timeout = 5, rollbackFor = Exception.class, isolation = Isolation.SERIALIZABLE)  // 只要遇到异常，事务就回滚
//    @Transactional(noRollbackFor = ArithmeticException.class)  // 遇到指定的异常，事务不回滚
    @Transactional(timeout = 3)
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

//        int a = 10 / 0;
//        FileInputStream fis = new FileInputStream("D:/ad/da.txt"); // 默认情况下，不是所有的异常都会使事务回滚
        return true;
    }
}
