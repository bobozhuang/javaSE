package main.java.com.bobozhuang.morethread.aqs.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description：    condition的用法： 开启了两个线程waiter和signaler，waiter线程开始执行的时候由于条件不满足，
 *                  执行condition.await方法使该线程进入等待状态同时释放锁，signaler线程获取到锁之后更改条件，
 *                  并通知所有的等待线程后释放锁。这时，waiter线程获取到锁，并由于signaler线程更改了条件此时
 *                  相对于waiter来说条件满足，继续执行。
 *
 * author Hubery
 * date 2020-11-13
 * version v0.0.1
 * since v0.0.1
 **/
public class ConditionTest3 {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread waiter = new Thread(new waiter());
        waiter.start();
        Thread signaler = new Thread(new signaler());
        signaler.start();
    }

    static class waiter implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                while (!flag) {
                    System.out.println(Thread.currentThread().getName() + "当前条件不满足等待");
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "接收到通知条件满足");
            } finally {
                lock.unlock();
            }
        }
    }

    static class signaler implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                flag = true;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
