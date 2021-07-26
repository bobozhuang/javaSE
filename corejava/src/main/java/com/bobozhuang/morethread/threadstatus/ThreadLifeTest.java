package main.java.com.bobozhuang.morethread.threadstatus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description： 查看线程状态
 * author Hubery
 * date 2020-11-17
 * version v0.0.1
 * since v0.0.1
 **/
public class ThreadLifeTest {

    public static void main(String[] args) throws IOException {
        Object object = new Object();
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(()->{
            synchronized (object) {
                try {
                    System.out.println("thread1 waiting");
                    //object.wait();
                    object.wait(50000);
                    System.out.println("thread1 after waiting");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread1").start();

        new Thread(()->{
            synchronized (object) {
                try {
                    System.out.println("thread2 notify");
                    // 打开或关闭这段注释，观察Thread1的状态为：BLOCKED
                    object.notify();
                    // notify之后当前线程并不会释放锁，只是被notify的线程从等待队列进入同步队列
                    // sleep也不会释放锁，所以 thread2 获取不到锁，处于 BLOCKED 状态
                    Thread.sleep(10000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread2").start();

        new Thread(()->{
            lock.lock();
            System.out.println("thread3 waiting");
            try {
                condition.await();  //await方法实现是通过park的，同时锁已经释放，但是线程放入了等待队列
                //condition.await(200, TimeUnit.SECONDS);
                //这个加了时间应该是 TIMED_WAITING 状态吧,但是jstack为WAITING 原来是用了debug启动的
                System.out.println("thread3 after waiting");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "Thread3").start();

        new Thread(()->{
            lock.lock();
            System.out.println("thread4");
            // 打开或关闭这段注释，观察Thread3的状态
            //condition.signal();
            // signal之后当前线程并不会释放锁，只是被signal的线程从等待队列进入同步队列
            // sleep也不会释放锁
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "Thread4").start();

        //这个不懂了为什么是WAITING？
        new Thread(()->{
            //lock.lock();
            System.out.println("thread5");
            LockSupport.parkNanos(2000000000000l);      //哦，这里和锁没关系，要把锁注释掉
            System.out.println("thread5 parkNanos end");
            //lock.unlock();
        }, "Thread5").start();
    }


}
