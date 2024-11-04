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
    @SneakyThrows  // @SneakyThrows 注解背后的实现原理是，Lombok 会在编译时自动为标记的方法生成 try-catch 语句，并在捕获到受检查异常时，将它们转换为 RuntimeException 类型的异常重新抛出，从而绕过了编译器对受检查异常的检查。
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
