package main.java.com.bobozhuang.morethread.lock;

import org.junit.Test;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description：     写的是狗屁
 * author Hubery
 * date 2020-09-01
 * version v0.0.1
 * since v0.0.1
 **/
public class LockTest {
    // 以下测试方法都获取这个锁
    private Lock lock = new ReentrantLock();

    @Test
    public void unblockTest() {
        Thread thread = new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquire lock");//acquire 获取
                SleepUtils.sleep(2);    //这里sleep 了一会下面就会获取锁失败
            } finally {
                lock.unlock();
            }
        });
        thread.start();

        SleepUtils.sleep(1);        //等待thread获取到锁   不等待的话 可能main方法就执行结束了
        if(lock.tryLock()) {        //尝试非阻塞获取锁，上面线程获取到了锁未释放，所以就会获取不到锁
            //do something
            System.out.println(Thread.currentThread().getName() + " acquire lock");
        } else {
            //do something
            System.out.println(Thread.currentThread().getName() + " acquire lock fail");
        }

    }

    /**
     * 写的是垃圾，没看懂
     */
    @Test
    public void interruptedTest() {
        Thread thread = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread-1 acquire lock");
                //SleepUtils.sleep(1113);

            } finally {
                lock.unlock();
                System.out.println("Thread-1 release lock");
            }
        });
       // thread.start();

        Thread thread2 = new Thread(() -> {
            boolean interrupted = false;
            try {
                //可中断的获取锁，和lock()的不同之处在于该方法会响应中断，即在锁的获取过程中可以中断该线程
                lock.lockInterruptibly();
                System.out.println("Thread-2 acquire lock");
            } catch (InterruptedException e) {
                //当获取锁时被中断，可以做其他的事情
                System.out.println("Thread2 is interrupted");
                interrupted = true;
            }
            if(!interrupted) {
                try {
                    System.out.println("Thread-2 acquire lock");
                    //SleepUtils.sleep(10);
                    //System.out.println("Thread-2 acquire lock");
                } finally {
                    System.out.println("Thread-2 release lock");
                    lock.unlock();
                    System.out.println("Thread-2 release lock");
                }
            }
        });

        //SleepUtils.sleep(10);        //等待线程1获取锁
        thread2.start();
       /* try {
            thread2.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //SleepUtils.sleep(1);        //等待线程2处于获取锁的过程中
        //thread2.interrupt();                //中断线程2

        //SleepUtils.sleep(2);
    }

    @Test
    public void timeoutTest() throws InterruptedException {
        Thread thread = new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquire lock");
                SleepUtils.sleep(6);//这里面的sleep 不管用呀，还没睡醒锁就释放了

            } finally {
                System.out.println(Thread.currentThread().getName() + " release lock");
                lock.unlock();
            }
        });
        thread.start();

        SleepUtils.sleep(3);            //等待thread获取到锁
        if(lock.tryLock(1, TimeUnit.SECONDS)) {        //超时获取锁
            //do something
            System.out.println(Thread.currentThread().getName() + " acquire lock");
        } else {
            //do something
            System.out.println(Thread.currentThread().getName() + " acquire lock time out");
        }
    }


}
