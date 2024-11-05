package com.naruto.ssm.transaction;

import com.naruto.ssm.transaction.Dao.AccountDao;
import com.naruto.ssm.transaction.Dao.BookDao;
import com.naruto.ssm.transaction.bean.Book;
import com.naruto.ssm.transaction.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author
 * @Date 2024/11/5 14:46
 * @Description:
 */
@SpringBootTest
public class TransactionApplicationTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate; // 就是QueryRunner

    @Autowired
    BookDao bookDao;

    @Autowired
    AccountDao accountDao;

    @Autowired
    UserService userService;

    @Test
    void test01() throws SQLException {

//        String sql = "insert into book(bookName,price,stock) values('剑指MySQL',79.50,15)";
//        jdbcTemplate.execute(sql);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    void test02() {
        Book book = bookDao.getBookById(2);
        System.out.println(book);
    }

    @Test
    void test03() {
        Book book = new Book();
        book.setBookName("Spring JDBC");
        book.setPrice(BigDecimal.valueOf(39.5));
        book.setStock(500);
        bookDao.addBook(book);
    }

    @Test
    void test04() {
        bookDao.updateBookStock(1, 80);
    }

    @Test
    void test05() {
        bookDao.deleteBook(4);
    }

    @Test
    void test06() throws Exception {
        accountDao.updateBalanceByUsername("zhangsan", BigDecimal.valueOf(45.8));
    }

    @Test
    void checkOut() throws Exception {
        boolean lisi = userService.checkOut("lisi", 3, 10);
        System.out.println(lisi ? "结账成功" : "结账失败");
    }
}
