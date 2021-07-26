package main.java.com.bobozhuang.morethread.aqs.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description：
 * author Hubery
 * date 2020-11-11
 * version v0.0.1
 * since v0.0.1
 **/
public class ConditionTest1 {



    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    condition.await();
                    //condition.await(1231, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            });
            thread.start();
        }
    }

}
