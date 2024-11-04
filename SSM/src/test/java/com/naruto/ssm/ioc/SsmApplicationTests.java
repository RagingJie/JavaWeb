package com.naruto.ssm.ioc;

import com.naruto.ssm.ioc.dao.Temp;
import com.naruto.ssm.ioc.dao.UserTemp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SsmApplicationTests {

    @Autowired
    UserTemp userTemp;

    @Autowired
    Temp temp;

    @Test
    void test01(){
        System.out.println(userTemp);
        temp.get();
    }

}
