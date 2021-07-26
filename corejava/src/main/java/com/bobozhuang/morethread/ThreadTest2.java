package main.java.com.bobozhuang.morethread;

/**
 * description：     Runnable 没有start接口，所以这里的start方法没有影响，启动线程是没有影响
 * author Hubery
 * date 2020-12-06
 * version v0.0.1
 * since v0.0.1
 **/
public class ThreadTest2 implements Runnable {
    public static void main(String[] args) {
        ThreadTest2 s = new ThreadTest2();
        Thread t = new Thread(s);
        t.start();
    }

    public void start() {
        System.out.println("start...");
    }

    public void run() {
        System.out.println("run....");
    }
}