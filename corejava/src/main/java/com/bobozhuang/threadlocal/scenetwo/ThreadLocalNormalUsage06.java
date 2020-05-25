package main.java.com.bobozhuang.threadlocal.scenetwo;

/**
 * description： 在一个线程的执行流程中不同的对象会操作同一个对象，我们可以把对象放到threadlocale，每次获取都是同一个
 *              例：流水号，当每次请求执行的线程开始执行就将生成的流水号存到threadlocal中，在之后发交易，存数据库等等操作时，
 *                  需要获取流水号时可直接获取，避免的在方法中传递对象。
 * author Hubery
 * date 2020-04-20
 * version v0.0.1
 * since v0.0.1
 **/
public class ThreadLocalNormalUsage06 {

    public static void main(String[] args) {
        new Service1().process();
    }

}
class Service1 {

    public void process() {
        User user = new User("鲁毅");
        //将User对象存储到 holder 中
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}

class Service2 {

    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service2拿到用户名: " + user.name);
        new Service3().process();
    }
}

class Service3 {

    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service3拿到用户名: " + user.name);
        //手动释放内存，从而避免内存泄漏
        UserContextHolder.holder.remove();
    }
}


class UserContextHolder {

    public static ThreadLocal<User> holder = new ThreadLocal<>();
}

class User {

    String name;

    public User(String name) {
        this.name = name;
    }
}