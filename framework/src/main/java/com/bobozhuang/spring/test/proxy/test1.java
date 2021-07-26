package com.bobozhuang.spring.test.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.*;

/**
 * description：
 * author Hubery
 * date 2020-11-04
 * version v0.0.1
 * since v0.0.1
 **/
public class test1 {

    @Test
    public void testJdkProxy() {
        Calculator calculator = new CalculatorImpl();
        Calculator o = (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(), calculator.getClass().getInterfaces(), new CalculatorJDKProxy(calculator));
        Double divide = o.divide(250.0, 5.0);
        System.out.println("输出的值为：" + divide);
    }


    @Test
    public void testCGLIB() {
        Enhancer enhancer = new Enhancer();
        System.out.println();
        enhancer.setSuperclass(CalculatorImpl.class);
        enhancer.setCallback(new CalculatorCGLIBProxy());
        Calculator o = (Calculator) enhancer.create();
        Double divide = o.divide(500.0, 3.0);
        System.out.println(divide);
    }

    @Test
    public void testPerformance() {
        //TODO JDK代理使用
        Map<String,String> map = new HashMap<>();
        Calculator calculator = new CalculatorImpl();
        Random random = new Random();
        // 创建Spring的计算类对象
        StopWatch stopWatch = new StopWatch();
        String taskName="JDK代理";
        stopWatch.start(taskName);
        Calculator o = (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(), calculator.getClass().getInterfaces(),new CalculatorJDKProxy(calculator));
        List<Double> list = new ArrayList<>(1000);
        addNumToList(o, random, list);
        Double aDouble = list.stream().max(Double::compareTo).get();
        System.out.println("JDK计算比较结束，集合最大的值为："+aDouble);
        stopWatch.stop();
        map.put(taskName,stopWatch.prettyPrint());
        list.clear();

        //TODO CGLIB代理使用
        taskName="CGLIB代理";
        stopWatch = new StopWatch();
        stopWatch.start(taskName);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CalculatorImpl.class);
        enhancer.setCallback(new CalculatorCGLIBProxy());
        Calculator o1 = (Calculator) enhancer.create();
        addNumToList(o1, random, list);
        System.out.println("CGLIB计算比较结束，集合最大的值为："+aDouble);
        stopWatch.stop();
        map.put(taskName,stopWatch.prettyPrint());
        System.out.println(map);
    }
    private void addNumToList(Calculator o, Random random, List<Double> list) {
        for (int i = 1; i < 10000; i++) {
            double a = (random.nextInt(i) + 1) * 1.0;
            double b = (random.nextInt(i) + 1) * 1.0;
            Double result = o.divide(a, b);
            list.add(result);
        }
    }

}
