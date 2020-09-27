package main.java.com.bobozhuang.designpattern.proxy.staticproxy;

/**
 * description：
 * author Hubery
 * date 2020-08-19
 * version v0.0.1
 * since v0.0.1
 **/
public class HelloServiceProxy implements HelloService{

    private HelloService target;

    public HelloServiceProxy(HelloService target) {
        this.target = target;
    }

    public void sayHello() {
        System.out.println("log:sayHello马上要执行了...");
        target.sayHello();
    }

}
