package com.naruto.ssm.transaction.service;

/**
 * @Author
 * @Date 2024/11/5 16:11
 * @Description:
 */
public interface UserService {

    /**
     * @param userName 用户名
     * @param bookId   书id
     * @param bookNum  买了几本书
     * @return boolean
     * @author Naruto
     * @date 2024/11/5 16:13
     * @description 用户购买书籍结账
     */
    boolean checkOut(String userName, Integer bookId, Integer bookNum) throws Exception;
}
