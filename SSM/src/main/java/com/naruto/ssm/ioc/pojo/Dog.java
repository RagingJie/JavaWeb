package com.naruto.ssm.ioc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @Author
 * @Date 2024/10/23 1:02
 * @Description:
 */
@Data
@Repository
public class Dog {

    private String attribute;

    public Dog(String attribute) {
        this.attribute = attribute;
        System.out.println("Dog的" + attribute + "全参构造器.....");
    }

    public Dog() {
        System.out.println("Dog的无参构造器.....");
    }
}
