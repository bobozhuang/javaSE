package main.java.com.bobozhuang.designpattern.proxy.CglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * description：
 * author Hubery
 * date 2020-08-19
 * version v0.0.1
 * since v0.0.1
 **/
public class MyCglibProxyFactory implements MethodInterceptor {


    public Object getInstance(Class<?> c) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(c);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args,MethodProxy proxy) throws Throwable {

        System.out.println("开始执行方法");
        //这句代码最终会执行到我们目标对象中的方法
        proxy.invokeSuper(obj, args);
        System.out.println("方法执行结束");

        return null;
    }
}
