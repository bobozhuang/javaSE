package main.java.com.bobozhuang.morethread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description：
 * author Hubery
 * date 2020-09-09
 * version v0.0.1
 * since v0.0.1
 **/
public class ReentrantLockTest2 {

    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ReentrantLockTest2 al = new ReentrantLockTest2();
        al.untimed(); // True -- 可以成功获得锁
        al.timed(); // True --可以成功获得锁
        //新创建一个线程获得锁并且不释放
        new Thread() {
            {
                setDaemon(true);
            }

            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.sleep(100);// 保证新线程能够先执行
        al.untimed(); // False -- 马上中断放弃
        al.timed(); // False -- 等两秒超时后中断放弃      都获取不到，但是加了等待时间，等不到就放弃
    }

}
