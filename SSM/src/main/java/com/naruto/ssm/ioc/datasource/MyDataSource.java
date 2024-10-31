package com.naruto.ssm.ioc.datasource;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author
 * @Date 2024/11/1 1:32
 * @Description:
 */
@Data
public class MyDataSource {

    private String url;
    private String username;
    private String password;
}
