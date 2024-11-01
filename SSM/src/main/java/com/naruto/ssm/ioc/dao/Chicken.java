package com.naruto.ssm.ioc.dao;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author
 * @Date 2024/11/1 11:22
 * @Description:
 */
@Data
@Component
public class Chicken {

    @Value("${chicken.name}")
    private String name;
    @Value("${chicken.age}")
    private Integer age;
}
