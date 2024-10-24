package com.naruto.ssm.ioc;

import ch.qos.logback.core.CoreConstants;
import com.naruto.ssm.controller.StuController;
import com.naruto.ssm.ioc.controller.UserController;
import com.naruto.ssm.ioc.pojo.Dog;
import com.naruto.ssm.ioc.pojo.Person;
import com.naruto.ssm.ioc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.util.Map;

@Import(CoreConstants.class)  // 直接往Spring的容器中注册某一个对象，只要是关于组件的注解，放在哪个层下面的类上都可以，只要能被Spring扫描到
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = "com.naruto.ssm")  // 组件批量扫描，只扫利用Spring相关注解注册到容器中的组件
public class SsmApplication {


    /*
     * 默认：分层注解能起作用的前提是，这些组件必须在主程序所在的包及其子包结构下
     *
     * Spring为我们提供了快速的MVC分层注解、
     *  1、@Controller 控制器
     *  2、@Service 服务层
     *  3、@Repository 持久层
     *  4、@Component 组件
     *
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(SsmApplication.class);

        System.out.println("===============ioc==============");

        UserController bean = ioc.getBean(UserController.class);
        System.out.println("UserController = " + bean);

        UserService bean1 = ioc.getBean(UserService.class);
        System.out.println("UserService = " + bean1);

        StuController bean2 = ioc.getBean(StuController.class);
        System.out.println("StuController = " + bean2);
    }

    /* 组件：框架的底层配置
     *  配置文件：指定配置
     *  配置类；分类管理组件的配置，配置类也是容器的一种组件
     *
     *
     * 组件创建时机：容器启动过程中会创建组件对象
     * 单实例特性：所有组件默认是单例的，每次获取直接从容器中拿，容器会提前创建组件
     */
    public static void test02BeanAnnotation(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(SsmApplication.class);

        System.out.println("===================ioc容器创建成功===================");

        // 获取组件
        Dog bean1 = ioc.getBean(Dog.class);
        System.out.println("beanDog = " + bean1);

        Dog bean2 = ioc.getBean(Dog.class);
        System.out.println("beanDog = " + bean2);

        Dog bean3 = ioc.getBean(Dog.class);
        System.out.println("beanDog = " + bean3);

        // 3. 按照组件类型获取这种类型的全部对象
        Map<String, Person> beansOfType = ioc.getBeansOfType(Person.class);
        System.out.println("type = " + beansOfType);

        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

    }

    public static void test01BeanAnnotation(String[] args) {
        // 返回的对象，实际就是spring的ioc容器，里面包含了sprig管理的类对象
        ConfigurableApplicationContext ioc = SpringApplication.run(SsmApplication.class, args);
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        // 获取容器中的组件对象；精确获取某个组件
        // 组件的四大特性：（名字、类型）、对象、作用域
        // 组件名字全局唯一；组件名重复了。一定只会给容器中放一个最先声明的那个

        // 1. 按组件的名字获取对象
        Person person = (Person) ioc.getBean("person");
        System.out.println("对象 = " + person);

        // 2. 按照组件类型获取对象
        Dog bean = ioc.getBean(Dog.class);
        System.out.println("bean = " + bean);

        // 3. 按照组件类型获取这种类型的全部对象
        Map<String, Person> beansOfType = ioc.getBeansOfType(Person.class);
        System.out.println("type = " + beansOfType);

        // 4. 按照名字+类型获取组件
        Person beanTwo = ioc.getBean("person", Person.class);
        System.out.println("beanTwo = " + beanTwo);

        // 5. 组件是单实例的......
    }

   /* @Bean("person")
    public Person ha() {
        Person person = new Person(20, "哈哈", "山东潍坊111", 175.6);
        return person;
    }

    @Bean
    public Person person() {
        Person person = new Person(18, "阿叼", "山东潍坊", 182.5);
        return person;
    }

    @Bean("personOne")
    public Person person1() {
        return new Person();
    }

    @Bean("dog")
    public Dog dog() {
        return new Dog();
    }*/

}
