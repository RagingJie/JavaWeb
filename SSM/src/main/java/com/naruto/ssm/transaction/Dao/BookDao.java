package com.naruto.ssm.transaction.Dao;

import com.naruto.ssm.transaction.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author
 * @Date 2024/11/5 15:05
 * @Description:
 */
@Component
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * @param id
     * @return void
     * @author Naruto
     * @date 2024/11/5 15:18
     * @description 根据id获取书的信息
     */
    public Book getBookById(Integer id) {
        // 编写sql
        String sql = " select * from book where id = ? ";  // ? 占位符
        Book book = null;
        try {
            // 执行sql并获取结果
            book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
        } catch (DataAccessException e) {
            System.out.println("运行sql时的错误信息：" + e.getMessage());
        }
        // 返回结果
        return book;
    }

    /**
     * @param book 图书
     * @return void
     * @author Naruto
     * @date 2024/11/5 15:37
     * @description 添加图书信息
     */
    public void addBook(Book book) {
        // insert sql
        String sql = "insert into book(bookName,price,stock) values(?,?,?)";

        try {
            // 执行sql
            jdbcTemplate.update(sql, book.getBookName(), book.getPrice(), book.getStock());
        } catch (DataAccessException e) {
            System.out.println("添加图书时，发生错误的信息：" + e.getMessage());
        }
    }

    /**
     * @param id       图书id
     * @param stockNum 扣减库存数
     * @return void
     * @author Naruto
     * @date 2024/11/5 15:48
     * @description 根据图书id更新库存
     */
    public void updateBookStock(Integer id, Integer stockNum) {
        // 扣减库存sql
        String sql = "update book set stock = stock-? where id = ?";
        try {
            // 执行sql
            jdbcTemplate.update(sql, stockNum, id);
        } catch (DataAccessException e) {
            System.out.println("根据图书id更新库存时，发生的错误信息：" + e.getMessage());
        }
    }

    /**
     * @param id 图书id
     * @return void
     * @author Naruto
     * @date 2024/11/5 15:48
     * @description 根据图书id删除图书
     */
    public void deleteBook(Integer id) {
        // 扣减库存sql
        String sql = "delete from book where id = ?";
        try {
            // 执行sql
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException e) {
            System.out.println("根据id删除图书信息，发生的错误信息：" + e.getMessage());
        }
    }
}
