package main.java.com.bobozhuang.morethread.mutex;

import main.java.com.bobozhuang.morethread.mutex.Mutex;

/**
 * description： 新建了10个线程，没有线程先获取锁，然后调用condition.await方法释放锁将当前线程加入到等待队列中，
 *                   通过debug控制当走到第10个线程的时候查看firstWaiter即等待队列中的头结点
 * author Hubery
 * date 2020-11-12
 * version v0.0.1
 * since v0.0.1
 **/
public class MutexDemo {

    private static Mutex mutex = new Mutex();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                mutex.lock();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.unlock();
                }
            });
            thread.start();
        }
    }

}
