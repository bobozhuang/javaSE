package main.java.com.bobozhuang.designpattern.proxy.staticproxy;

/**
 * description：
 * author Hubery
 * date 2020-08-19
 * version v0.0.1
 * since v0.0.1
 **/
public class Test {

    public static void main(String[] args) {
        //目标对象
        HelloService target = new HelloServiceImpl();
        //代理对象
        HelloService proxy = new HelloServiceProxy(target);
        proxy.sayHello();
    }

}
