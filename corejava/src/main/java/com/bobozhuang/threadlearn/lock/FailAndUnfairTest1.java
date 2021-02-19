package main.java.com.bobozhuang.threadlearn.lock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description： 测试： 公平锁/非公平锁   展示等待锁的线程，并且验证线程执行的顺序
 *          Java的synchronized块不保证尝试进入它的线程被授予访问权限的顺序。因此，如果许
 *          多线程经常竞争访问同一个同步块，则存在一个或多个线程永远不被授予访问权限的风险—— 访问总是被授予其他线程，这被
 *          称为饥饿。为了避免这种情况通过Lock的实现在内部使用同步块，因此它不保证公平性。饥饿和公平在“ 饥饿与公平 ”一文
 *          中有更详细的讨论 。
 *
 * author Hubery
 * date 2020-09-01
 * version v0.0.1
 * since v0.0.1
 **/
public class FailAndUnfairTest1 {

    private static Lock fairLock = new ReentrantLock2(true);    //公平锁
    private static Lock unfairLock = new ReentrantLock2(false); //非公平锁

    @Test
    public void fair() {
        testLock(fairLock);
    }

    @Test
    public void unfair() {
        // 这个非公平锁的 测试结果并没有说服力，看结果还是按照顺序
        // 我认为当前线程可以2次获取到锁是因为 ReentrantLock 是可重入的，
        testLock(unfairLock);

    }

    private void testLock(Lock lock) {
        for(int i = 0; i < 5; ++i) {
            Thread thread = new Thread(new Job(lock), "fair" + i);
            thread.start();
        }


        SleepUtils.sleep(8000);
        Thread thread = new Thread(new Job(lock), "fair" + 9);
        thread.start();

    }

    private static class Job implements Runnable {
        private Lock lock;

        Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            // 连续两次打印当前的线程和等待队列中的线程
            for(int i = 0; i < 2; ++i) {
                System.out.println("--");
                lock.lock();
                try {
                    System.out.println("Lock by " + Thread.currentThread().getName() +
                            ", Waiting by " + ((ReentrantLock2) lock).getQueuedThreadNames());
                } finally {
                    /*try {
                        //获取到锁等1s 在释放
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    lock.unlock();
                }
            }
        }
    }

    private static class ReentrantLock2 extends ReentrantLock {
        ReentrantLock2(boolean fair) {
            super(fair);
        }

        @Override
        public Collection<Thread> getQueuedThreads() {
            //getQueuedThreads 这个方法是
            List<Thread> threads = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(threads);
            return threads;
        }

        public Collection<String> getQueuedThreadNames() {
            List<String> names = new ArrayList<>(80);
            getQueuedThreads().forEach((s) -> names.add(s.getName()));
            return names;
        }
    }
}
