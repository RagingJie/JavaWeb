package com.study.springboot;

import com.study.springboot.bean.Person;
import com.study.springboot.properties.DogProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class DataSourceTest {

    @Autowired
    DataSource dataSource;
    @Autowired
    DogProperties dogProperties;
    @Autowired
    Person person;

    @Test
    public void test() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void test2() {
        System.out.println(dogProperties.toString());
    }


    @Test
    public void test3() {
        System.out.println(person.toString());
    }
}
