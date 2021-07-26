package main.java.com.bobozhuang.morethread.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description：
 * author Hubery
 * date 2020-09-22
 * version v0.0.1
 * since v0.0.1
 **/
public class ReentrantLockTest3 {

    public static void main(String[] args) {
        Lock nonFairLock = new ReentrantLock(false);
        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().toString() + " pre run...");
                    nonFairLock.lock();
                    Thread.sleep(1_000);
                    System.out.println(Thread.currentThread().toString() + " run!!!!!!!!!!!!!!!!!!");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().toString() + " pre unlock@@@");
                    nonFairLock.unlock();
                }

            }
        }, "firstThread");

        //第一个线程先获取到锁
        firstThread.start();


        List<Thread> threadList = new ArrayList<>();
        //定义101个线线，标号都为2000到2100之间
        for (int i = 2000; i < 2101; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().toString() + " pre run...");
                        nonFairLock.lock();
                        System.out.println(Thread.currentThread().toString() + " run!!!");
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        nonFairLock.unlock();
                    }
                }
            }, "thread_" + i);
            threadList.add(thread);
        }


        //让N个线程去排队获取锁,标号都为100以下
        for (int i = 0; i < 101; i++) {
            int finalI = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().toString() + " pre run...");
                        nonFairLock.lock();
                        System.out.println(Thread.currentThread().toString() + " run!!!");
                        Thread.sleep(10);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        nonFairLock.unlock();
                        if (finalI == 0) {
                            threadList.forEach(thread1 -> {
                                thread1.start();
                            });
                        }
                    }
                }
            }, "thread*" + i);
            thread.start();
        }
    }
}
