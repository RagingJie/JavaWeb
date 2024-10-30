package com.naruto.ssm.ioc.common.config;

import com.naruto.ssm.ioc.common.condition.MacCondition;
import com.naruto.ssm.ioc.common.condition.WindowsCondition;
import com.naruto.ssm.ioc.pojo.Person;
import org.springframework.context.annotation.*;

/**
 * @Author
 * @Date 2024/10/23 1:21
 * @Description:
 */
//@Conditional(WindowsCondition.class)
@Configuration  // 告诉Spring容器，这是一个配置类
public class PersonConfig {

    @Conditional(MacCondition.class)
    @Bean("apple")
    public Person apple() {
        Person person = new Person(22, "苹果", "广东苹果", 180.8);
        return person;
    }

    @Primary  // 主组件  /  默认组件
    @Conditional(WindowsCondition.class)
    @Bean("aHua")
    public Person aHua() {
        Person person = new Person(44, "阿花", "广东深圳", 166.6);
        return person;
    }

    @Scope("singleton") // 默认值，单实例
    @Bean("person")
    public Person ha() {
        Person person = new Person(20, "哈哈", "山东潍坊111", 175.6);
        return person;
    }

    @Bean("lisi")
    public Person person() {
        Person person = new Person(18, "阿叼", "山东潍坊", 182.5);
        return person;
    }

    @Scope("prototype")
    @Bean("personOne")
    public Person person1() {
        return new Person();
    }
}
