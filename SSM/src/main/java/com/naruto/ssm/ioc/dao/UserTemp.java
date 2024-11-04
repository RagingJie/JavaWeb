package com.naruto.ssm.ioc.dao;

import com.naruto.ssm.ioc.annotate.UUID_ID;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author
 * @Date 2024/11/2 20:10
 * @Description:
 */
@Data
@Component
public class UserTemp {

    @UUID_ID(value = "1")
    private String id;
}
