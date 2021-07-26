package com.bobozhuang.spring.test.proxy;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * description：
 * author Hubery
 * date 2020-11-04
 * version v0.0.1
 * since v0.0.1
 **/
public class CalculatorCGLIBProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB代理之前执行的程序逻辑");
        // 执行被代理对象的方法
        Object invokeSuper = methodProxy.invokeSuper(o, objects);
        List<Object> list = Arrays.asList(objects);
        double sum = list.stream().mapToDouble(e -> Double.parseDouble(e.toString().trim())).sum();
        if (sum > 50.0) {
            System.out.println("计算的值大于50了");
        }
        System.out.println("CGLIB代理之后执行的程序逻辑");
        return invokeSuper;
    }
}

