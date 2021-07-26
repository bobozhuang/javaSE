package main.java.com.bobozhuang.morethread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * description：读/写锁     ReentrantReadWriteLock 是 ReadWriteLock 的一种实现
 *              多个线程可同时读共享变量
 *              只允许一个线程写共享变量
 *              写线程正在执行写操作，禁止其他线程读写共享变量
 *
 *              读写锁非常适合读多写少的场景。读写锁与互斥锁的一个重要区别是读写锁允许多个线程同时读共享变量，
 *              这是读写锁在读多写少的情况下性能较高的原因。
 *
 * author Hubery
 * date 2020-09-01
 * version v0.0.1
 * since v0.0.1
 **/
public class ReadWriteLockTest1 {

    final static ReadWriteLock rwLock = new ReentrantReadWriteLock();

    final static Lock readLock = rwLock.readLock();//读锁

    final static Lock writeLock = rwLock.writeLock();//写锁

    static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ":" + get());
            }).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " add");
                add();
            }).start();
        }
    }

    private static int get() {
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }

    private static void add() {
        writeLock.lock();
        try {
            count++;
        } finally {
            writeLock.unlock();
        }
    }

}
