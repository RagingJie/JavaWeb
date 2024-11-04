package com.naruto.ssm.ioc.processor;

import com.naruto.ssm.ioc.annotate.UUID;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @Author
 * @Date 2024/11/4 22:55
 * @Description: UUID后置处理器，在类初始化前，将有被@UUID注解表示的变量值赋值上UUID
 */
@Component
public class UUIDPostProcessor implements BeanPostProcessor {

    @Override
    @SneakyThrows
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 获取类的所有变量
        Field[] fields = bean.getClass().getDeclaredFields();
        // 遍历所有变量并查看哪些变量被@UUID标注并且类型是String类型的，那就给这个变量设UUID的值
        for (Field field : fields) {
            // 是不是String类型的；并且是不是被@UUID修饰的
            if (field.isAnnotationPresent(UUID.class) && field.getType().equals(String.class)) {
                // 暴力反射
                field.setAccessible(true);
                // 获取注解对象
                UUID uuid = field.getAnnotation(UUID.class);
                // 注解对象中value的值
                String value = uuid.value();
                if (!value.equals("")) {
                    field.set(bean, value);
                } else {
                    String UUID = java.util.UUID.randomUUID().toString().replace("-", "");
                    // 设置UUID值
                    field.set(bean, UUID);
                }
            }
        }
        return bean;
    }
}
