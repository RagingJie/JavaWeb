package com.naruto.ssm.ioc;

import ch.qos.logback.core.CoreConstants;
import com.naruto.ssm.controller.StuController;
import com.naruto.ssm.ioc.controller.UserController;
import com.naruto.ssm.ioc.dao.*;
import com.naruto.ssm.ioc.pojo.Cat;
import com.naruto.ssm.ioc.pojo.Dog;
import com.naruto.ssm.ioc.pojo.Person;
import com.naruto.ssm.ioc.pojo.Pig;
import com.naruto.ssm.ioc.service.AwareService;
import com.naruto.ssm.ioc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

@Import(CoreConstants.class)  // 直接往Spring的容器中注册某一个对象，只要是关于组件的注解，放在哪个层下面的类上都可以，只要能被Spring扫描到
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = "com.naruto.ssm")  // 组件批量扫描，只扫利用Spring相关注解注册到容器中的组件
public class SsmApplication {

    /*
        Bean的生命周期
    */
    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(SsmApplication.class, args);
        System.out.println("\n===============ioc容器创建=============\n");

        User user = ioc.getBean("user", User.class);
        System.out.println("运行user=>" + user);

    }

    /**
     * @param args
     * @return void
     * @author Naruto
     * @date 2024/11/1 9:53
     * @description spring原生方式，创建ioc容器
     */
    public static void test13BeanAnnotation(String[] args) {
        // 文件系统，其他盘中找
        new FileSystemXmlApplicationContext();

        // 使用类路径去找
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:dev.xml");
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName=> " + beanDefinitionName);
        }

        Car xiaomi = ioc.getBean("XIAOMI", Car.class);
        System.out.println("xiaomi=> " + xiaomi);

        Map<String, Chicken> beansOfType = ioc.getBeansOfType(Chicken.class);
        System.out.println(beansOfType);
    }

    /*
         注解：@Profile()  理解多环境
    */
    public static void test12BeanAnnotation(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(SsmApplication.class, args);
        System.out.println("ioc容器创建成功！！！");

        DeliveryDao bean = ioc.getBean(DeliveryDao.class);
        bean.saveDeliveryDao();
        System.out.println(bean);
    }

    /*
         @Value注解使用
     */
    public static void test11BeanAnnotation(String[] args) throws IOException {
        ConfigurableApplicationContext ioc = SpringApplication.run(SsmApplication.class);
        System.out.println("ioc容器创建成功！！！");

        Cat cat = ioc.getBean(Cat.class);
        System.out.println("cat=>" + cat);

        Pig pig = ioc.getBean(Pig.class);
        System.out.println("pig=> " + pig);

        // 资源工具
        File file = ResourceUtils.getFile("classpath:image/头像.jpg");
        System.out.println(file);
        int available = new FileInputStream(file).available();
        System.out.println("文件大小=>" + available);
    }

    /*
         感知接口的实现运用
     */
    public static void test10BeanAnnotation(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(SsmApplication.class);
        System.out.println("ioc容器创建成功！！！");

        AwareService awareService = ioc.getBean(AwareService.class);
        System.out.println("perceptionService=> " + awareService);

        System.out.println("osType=>" + awareService.getOsType());

        System.out.println("Bean名字=>" + awareService.getBeanName());
    }


    /*
         构造器注入，set方法注入
     */
    public static void test09BeanAnnotation(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(SsmApplication.class);
        System.out.println("ioc容器创建成功！！！");

        UserDao userDao = ioc.getBean(UserDao.class);
        System.out.println("userDao=> " + userDao);
    }

    /*
         测试自动注入
     */
    public static void test08BeanAnnotation(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(SsmApplication.class);
        System.out.println("ioc容器创建成功！！！");

        UserService userService = ioc.getBean(UserService.class);
        System.out.println("userService=> " + userService);
    }

    /*
         测试自动注入
     */
    public static void test07BeanAnnotation(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(SsmApplication.class);
        System.out.println("ioc容器创建成功！！！");

        UserController userController = ioc.getBean(UserController.class);
        System.out.println("userController=> " + userController);
    }

    /**
     * @param args
     * @return void
     * @author Naruto
     * @date 2024/10/30 16:06
     * @description 条件注册
     */
    public static void test06BeanAnnotation(String[] args) {
        // ioc容器
        ConfigurableApplicationContext ioc = SpringApplication.run(SsmApplication.class);

        Map<String, Person> beansOfType = ioc.getBeansOfType(Person.class);
        System.out.println(beansOfType);

//        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }

        ConfigurableEnvironment environment = ioc.getEnvironment();
        String os = environment.getProperty("OS");
        System.out.println("系统=> " + os);

        Map<String, Person> beansOfType2 = ioc.getBeansOfType(Person.class);
        System.out.println("person=> " + beansOfType2);

        Map<String, Dog> beansOfType1 = ioc.getBeansOfType(Dog.class);
        System.out.println("dogs=> " + beansOfType1);
    }

    // FactoryBean在容器中放的组件的类型，是接口中泛型指定的类型，组件的名字是 工厂自己
    public static void test05BeanAnnotation(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(SsmApplication.class);

        Car bean1 = ioc.getBean(Car.class);
        Car bean2 = ioc.getBean(Car.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        System.out.println(bean1 == bean2);

        Map<String, Car> beansOfType = ioc.getBeansOfType(Car.class);
        System.out.println("beansOfType = " + beansOfType);
    }

    /*
         @Scope 调整组件的作用域：
         1、@Scope("prototype")：非单实例
            容器启动的时候不会创建非单实例组件的对象
            什么时候获取，什么时候创建
         2、@Scope("singleton)：单实例
            容器启动的时候会创建单实例组件的对象
            容器启动完成之前就会创建好
            @Lazy：懒加载    ==》单例模式下，可以继续调整为懒加载
                容器启动完成之前不会创建懒加载组件的对象
                什么时候获取，什么时候创建
         3、@Scope("request")：同一个请求单实例
         4、@Scope("session")：同一次会话单实例
     */
    public static void test04BeanAnnotation(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(SsmApplication.class);

        System.out.println("==========ioc容器创建完成==========");

        Object bean1 = ioc.getBean("person");
        System.out.println("bean1 = " + bean1.toString());
        System.out.println("bean1 = " + bean1);

        Object bean2 = ioc.getBean("person");
        System.out.println("bean2 = " + bean2);

        // 容器创建的时候（完成之前）就把所有的单实例对象创建完成
        System.out.println(bean1 == bean2);

        Object personOne1 = ioc.getBean("personOne");
        System.out.println("personOne2 = " + personOne1);

        Object personOne2 = ioc.getBean("personOne");
        System.out.println("personOne2 = " + personOne2);

        Object dog = ioc.getBean("dog");
        System.out.println("dog = " + dog);
    }

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
    public static void test03BeanAnnotation(String[] args) {
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
