package main.java.com.bobozhuang.designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * description：
 * author Hubery
 * date 2020-08-19
 * version v0.0.1
 * since v0.0.1
 **/
public class MyHandler implements InvocationHandler {

    private Object target;  //需要代理的目标对象

    private StudentLogger logger = new StudentLogger();

    public MyHandler(Object target, StudentLogger logger) {
        this.target = target;
        this.logger = logger;
    }

    public MyHandler(Object target) {
        this.target = target;
    }

    //参数1 proxy  将来给目标对象所动态产生的代理对象
    //参数2 method 将来你所调用的目标对象中的方法的镜像
    //参数3 args	   将来你所调用方法的时候所传的参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String msg = method.getName() + "方法被调用了...";
        logger.log(msg);
        Object o = method.invoke(target, args);
        return o;
    }


}
