package com.naruto.ssm.aop.proxy.dynamic;

import com.naruto.ssm.aop.calculator.MathCalculator;
import com.naruto.ssm.aop.log.LogUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author
 * @Date 2024/11/4 1:29
 * @Description:
 */

// 动态代理  运行期间才决定好了代理关系（拦截器，拦截所有）
// 定义：目标对象在执行期间会被动态拦截，插入指定逻辑
// 优点：可以代理世间万物
// 缺点：不好写

// 动态代理：JDK动态代理;
//      强制要求：目标对象【必有接口】。代理的也【只是接口规定的方法】。************
public class DynamicProxy {

    public DynamicProxy() {
    }


    /**
     * @param object 代理对象
     * @return java.lang.Object
     * @author Naruto
     * @date 2024/11/4 10:24
     * @description 创建动态代理
     */
    /*public static Object createProxy(Object object) {
        // 创建代理对象
        Object obj = Proxy.newProxyInstance(
                DynamicProxy.class.getClassLoader(),  // 类加载器
                new Class[]{MathCalculator.class}, // 代理的接口，必须是接口，这样只能调用特定的代理对象的接口
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 可以在代理的这个地方做手脚，这个地方就是做代理处理的地方
                        args[0] = 10000;
                        // 运行方法，反射知识点中的方法运行
                        return method.invoke(object, args);
                    }
                }
        );
        // 返回代理对象
        return obj;
    }*/


    /**
     * @param target 代理对象
     * @return java.lang.Object
     * @author Naruto
     * @date 2024/11/4 10:27
     * @description 创建动态代理
     */
    public static Object createProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    Object result = null;
                    try {
                        LogUtil.logStart(method.getName(), args);
                        result = method.invoke(target, args);
                        LogUtil.logReturn(method.getName(), result);
                        return result;
                    } catch (Exception e) {
                        LogUtil.logException(method.getName(), e);
                    } finally {
                        LogUtil.logEnd(method.getName());
                    }
                    return result;
                }
        );
    }
}
