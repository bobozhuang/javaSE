package main.java.com.bobozhuang.morethread;

/**
 * description：     继承Thread类实现一个线程类
 *
 * author Hubery
 * date 2020-03-21
 * version v0.0.1
 * since v0.0.1
 **/
public class BuildThreadOne {
    public static void main(String[] args) {
        for (int i = 0;i < 10 ;i++){
            DemoThread t = new DemoThread();
            t.start();
            System.out.println(t.getName());
        }

    }
}

class DemoThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

