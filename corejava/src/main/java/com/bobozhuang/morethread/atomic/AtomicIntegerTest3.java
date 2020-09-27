package main.java.com.bobozhuang.morethread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * description：改造成AtomicInteger原子类型，不会出现安全问题，AtomicInteger.incrementAndGet()方法的原子性
 * author Hubery
 * date 2020-05-08
 * version v0.0.1
 * since v0.0.1
 **/
public class AtomicIntegerTest3 {


    private static final int THREADS_CONUT = 1;
    public static AtomicInteger count = new AtomicInteger(0);

    public static void increase() {
        count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_CONUT];
        for (int i = 0; i < THREADS_CONUT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        Thread.sleep(100);
        System.out.println(count);
    }




}
