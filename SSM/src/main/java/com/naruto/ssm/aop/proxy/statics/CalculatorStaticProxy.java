package com.naruto.ssm.aop.proxy.statics;

import com.naruto.ssm.aop.calculator.MathCalculator;
import lombok.Data;

/**
 * @Author
 * @Date 2024/11/3 13:11
 * @Description: 计算器静态代理对象
 */

// 静态代理： 编码时，期间就决定好了代理的关系
//   定义：代理对象，是目标对象的接口的子类型，代理对象本身并不是目标对象，而是将目标对象作为自己的属性
//   优点：同一种类型的所有对象都能代理
//   缺点：范围太小，只能负责部分接口代理功能

// 动态代理  运行期间才决定好了代理关系（拦截器，拦截所有）
// 定义：目标对象在执行期间会被动态拦截，插入指定逻辑
// 优点：可以代理世间万物
// 缺点：不好写
@Data
public class CalculatorStaticProxy implements MathCalculator {

    private MathCalculator target;

    public CalculatorStaticProxy(MathCalculator mc) {
        this.target = mc;
    }

    @Override
    public int add(int x, int y) {
        System.out.println("【日志】add开始，参数：" + x + "," + y);
        int result = target.add(x, y);
        System.out.println("【日志】add返回，结果：" + result);
        return result;
    }

    @Override
    public int sub(int x, int y) {
        int result = target.sub(x, y);
        return result;
    }

    @Override
    public int multiply(int x, int y) {
        int result = target.multiply(x, y);
        return result;
    }

    @Override
    public int divide(int x, int y) {
        int result = target.divide(x, y);
        return result;
    }
}
