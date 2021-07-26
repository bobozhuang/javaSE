package com.bobozhuang.spring.test.proxy;

import org.junit.Test;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
import java.util.*;

/**
 * description：     https://blog.csdn.net/javaee_gao/article/details/106596492?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param
 * author Hubery
 * date 2020-11-04
 * version v0.0.1
 * since v0.0.1
 **/
public class test2 {


    private void addNumToList(Calculator o, Random random, List<Double> list) {
        for (int i = 1; i < 10000; i++) {
            double a = (random.nextInt(i) + 1) * 1.0;
            double b = (random.nextInt(i) + 1) * 1.0;
            Double result = o.divide(a, b);
            list.add(result);
        }
    }

    public void runCGLIBTest(ProxyFactory proxyFactory, Calculator calculator, int num, Map<String, Long> map) {
        // 当结果为true将使用CGLIB代理否则为JDK代理，默认为false
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.setFrozen(true);
        testCode(calculator, num, map);
    }

    public void runJDKTest(ProxyFactory proxyFactory, Calculator calculator, int num, Map<String, Long> map) {
        // 当结果为true将使用CGLIB代理否则为JDK代理，默认为false
        proxyFactory.setProxyTargetClass(false);
        proxyFactory.setInterfaces(calculator.getClass().getInterfaces());
        testCode(calculator, num, map);
    }

    public void testCode(Calculator calculator, int num, Map<String, Long> map) {

        StopWatch stopWatch = new StopWatch();
        Random random = new Random();
        stopWatch.start("divide");
        List<Double> list = new ArrayList<>();
        addNumToList(calculator, random, list);
        Double aDouble = list.stream().max(Double::compareTo).get();
        System.out.println("计算比较结束，集合最大的值为：" + aDouble);
        stopWatch.stop();
        map.put("divide", stopWatch.getLastTaskTimeMillis());
        stopWatch.start("equals");
        for (int i = 0; i < num; i++) {
            calculator.equals(calculator);
        }
        stopWatch.stop();
        map.put("equals", stopWatch.getLastTaskTimeMillis());

        stopWatch.start("hashCode");
        for (int i = 0; i < num; i++) {
            calculator.hashCode();
        }
        stopWatch.stop();
        map.put("hashCode", stopWatch.getLastTaskTimeMillis());


        Advised advised = (Advised) calculator;
        stopWatch.start("hashCode");
        for (int i = 0; i < num; i++) {
            advised.getTargetClass();
        }
        stopWatch.stop();
        map.put("advised.getTargetClass()", stopWatch.getLastTaskTimeMillis());
    }

    @Test
    public void testProxyPerformance() {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        Map<String, Long> map = new HashMap<>();
        Calculator calculator = applicationContext.getBean("calculator", Calculator.class);//这个时获取不到的，因为没有注入
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("divide");
        AfterReturningAdvice advice = new AfterReturningAdvice() {
            @Override
            public void afterReturning(@Nullable Object returnValue, Method method, Object[] args, @Nullable Object target) throws Throwable {
            }
        };
        PointcutAdvisor pointcutAdvisor = new DefaultPointcutAdvisor(pointcut, advice);
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(pointcutAdvisor);
        proxyFactory.setTarget(calculator);
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        runCGLIBTest(proxyFactory, proxy, 5000000, map);
        System.out.println("CGLIB---map:"+map);
        map.clear();
        runJDKTest(proxyFactory, proxy, 5000000, map);
        System.out.println("JDK---map:"+map);
    }
}
