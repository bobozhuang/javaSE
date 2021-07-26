package main.java.com.bobozhuang.morethread;

/**
 * description：     继承线程类，重写start方法后，执行start方法就不会创建线程了
 * author Hubery
 * date 2020-12-06
 * version v0.0.1
 * since v0.0.1
 **/
public class ThreadTest3 extends Thread {
    public static void main(String[] args) {
        ThreadTest3 t = new ThreadTest3();
        t.start();
    }

    public void start() {
        System.out.println("start");
    }

    public void run() {
        System.out.println("run");
    }
}
