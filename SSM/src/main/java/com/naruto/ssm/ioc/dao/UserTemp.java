package com.naruto.ssm.ioc.dao;

import com.naruto.ssm.ioc.annotate.UUID;
import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @Author
 * @Date 2024/11/2 20:10
 * @Description:
 */
@Data
@Repository
@Scope("prototype")
public class UserTemp {

    @UUID(value = "test001")
    private String id;
}
