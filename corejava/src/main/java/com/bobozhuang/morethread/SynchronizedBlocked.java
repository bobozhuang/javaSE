package main.java.com.bobozhuang.morethread;

import java.util.concurrent.TimeUnit;

/**
 * description：     中断线程,无法生效
 * author Hubery
 * date 2020-04-27
 * version v0.0.1
 * since v0.0.1
 **/
public class SynchronizedBlocked implements Runnable {

    public synchronized void f() {
        System.out.println("Trying to call f()");
        while (true) {
            // Never releases lock
            System.out.println("-----");
            Thread.yield();
        }

    }

    /**
     * 在构造器中创建新线程并启动获取对象锁
     */
    public SynchronizedBlocked() {
        // 该线程已持有当前实例锁
        new Thread() {
            public void run() {
                f(); // Lock acquired by this thread
            }
        }.start();
    }

    public void run() {
        // 中断判断
        while (true) {
            System.out.print("");
            if (Thread.interrupted()) {
                System.out.println("中断线程!!");
                break;
            } else {
                f();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedBlocked sync = new SynchronizedBlocked();
        Thread t = new Thread(sync);
        // 启动后调用f()方法,无法获取当前实例锁处于等待状态
        t.start();
        TimeUnit.SECONDS.sleep(1);
        // 中断线程,无法生效
        t.interrupt();
    }

}
