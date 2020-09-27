package main.java.com.bobozhuang.designpattern.proxy.simpleproxy;

/**
 * description： 这个简单代理就是静态代理
 * author Hubery
 * date 2020-08-19
 * version v0.0.1
 * since v0.0.1
 **/
public class Proxy implements Sourceable {

    private Source source;

    public Proxy(Source source) {
        this.source = source;
    }

    private void atfer() {
        System.out.println("after proxy!");
    }

    private void before() {
        System.out.println("before proxy!");
    }

    @Override
    public void method() {
        before();
        source.method();
        atfer();
    }
}

