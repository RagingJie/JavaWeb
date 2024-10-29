package com.naruto.ssm.ioc.common.factory;

import com.naruto.ssm.ioc.dao.Car;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Author
 * @Date 2024/10/25 2:28
 * @Description:
 */
// 场景：如果制造某些对象比较复杂的时候，利用工厂方法进行创建。
@Component
public class BYDFactory implements FactoryBean<Car> {

    /**
     * @return com.naruto.ssm.ioc.dao.Car
     * @author Naruto
     * @date 2024/10/25 2:31
     * @description 调用此方法给容器中制造对象
     */
    @Override
    public Car getObject() throws Exception {
        System.out.println("容器正在制造Car......");
        Car car = new Car();
        return car;
    }

    /**
     * @return java.lang.Class<?>
     * @author Naruto
     * @date 2024/10/25 2:33
     * @description 说明造的东西的类型
     */
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    /**
     * @return boolean
     * @author Naruto
     * @date 2024/10/25 2:34
     * @description 是单例吗？
     * 默认是单例的
     * true:是单例的
     * false：不是单例的
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
