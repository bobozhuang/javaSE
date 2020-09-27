package main.java.com.bobozhuang.designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * description：
 *              newProxyInstance方法执行了以下几种操作。
 *
 *  1.生成一个实现了参数interfaces里所有接口且继承了Proxy的代理类的字节码，然后用参数里的classLoader加载这个代理类。
 *
 *  2.使用代理类父类的构造函数 MyHandler(target)来创造一个代理类的实例，将我们自定义的InvocationHandler的子类传入。
 *
 *  3.返回这个代理类实例。
 *
 *  在main方法中加入System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true")，
 *
 *  这样就会把生成的代理类Class文件保存在本地磁盘上，然后再反编译可以得到代理类的源码：
 *
 *  我们可以看到代理类内部实现比较简单，在调用每个代理类每个方法的时候，都用反射去调newProxyInstanceh方法中传来的h的invoke方法
 *
 *  (也就是我们自定义的InvocationHandler的子类中重写的invoke方法)，用参数传递了代理类实例、接口方法、调用参数列表，这样我们在
 *
 *  重写的invoke方法中就可以实现对所有方法的统一包装了。
 *
 *  https://www.cnblogs.com/zeenzhou/p/11103960.html
 *
 * author Hubery
 * date 2020-08-19
 * version v0.0.1
 * since v0.0.1
 **/
public class DProxyTest {

    public static void main(String[] args) {

        IStudentService target = new StudentServiceImpl();  // 创建目标代理对象

        ClassLoader loader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler h = new MyHandler(target);

        //参数1 loader 		目标对象的类加载器
        //参数2 interfaces	目标对象所实现的接口
        //参数3 h		 	InvocationHandler接口的实现类对象
        IStudentService proxy = (IStudentService) Proxy.newProxyInstance(loader, interfaces, h);

        proxy.delete(1);
        proxy.save(null);
        proxy.find(1);

        System.out.println(proxy.toString());
        System.out.println(proxy.getClass());
        System.out.println(target.getClass());
    }

}
