package com.study.springboot;

import com.study.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProfileTest {

    @Autowired
    private Person person;

    @Test
    public void test01() {
        System.out.println(person.toString());
    }
}
