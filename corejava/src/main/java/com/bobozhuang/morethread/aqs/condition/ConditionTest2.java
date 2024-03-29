package main.java.com.bobozhuang.morethread.aqs.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description：
 * author Hubery
 * date 2020-11-12
 * version v0.0.1
 * since v0.0.1
 **/
public class ConditionTest2 {

    public static void main(String[] args) throws InterruptedException {
        final Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        //睡觉线程
        new Thread(()->{
            lock.lock();
            try {
                System.out.println("开始睡觉");
                condition.await();
                System.out.println("醒啦！！！！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();
        //让上面线程先完成
        Thread.sleep(1000);
        //唤醒线程
        new Thread(()->{
            lock.lock();
            try {
                System.out.println("准备唤醒");
                condition.signal();
            } finally {
                lock.unlock();
            }
        }).start();
    }


}
