package main.java.com.bobozhuang.designpattern.proxy.simpleproxy;

/**
 * description：
 * author Hubery
 * date 2020-08-19
 * version v0.0.1
 * since v0.0.1
 **/
public class ProxyTest {
    public static void main(String[] args) {
        Source target = new Source();
        Sourceable proxy = new Proxy(target);
        proxy.method();
    }
}
