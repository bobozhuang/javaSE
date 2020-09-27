package lock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description：     测试ReentrantLock可重入，原理就是如果调用lock方法的还是当前对象，就对锁的状态加1
 *              java.util.concurrent.locks.ReentrantLock.Sync#nonfairTryAcquire(int)
 *
 * author Hubery
 * date 2020-09-10
 * version v0.0.1
 * since v0.0.1
 **/
public class FailAndUnfairTest2 {


    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock2(false);
        Thread fair = new Thread(new Job(reentrantLock), "fair");
        fair.start();

        Thread.sleep(3000l);
    }

    private static class Job implements Runnable {
        private Lock lock;

        Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            // 连续两次打印当前的线程和等待队列中的线程
            for(int i = 0; i < 5; ++i) {
                lock.lock();
                try {
                    System.out.println("Lock by " + Thread.currentThread().getName() +
                            ", Waiting by " + ((ReentrantLock2) lock).getQueuedThreadNames());
                } finally {
                    //这里不释放锁那么run方法执行完也会释放
                    //lock.unlock();
                }
            }

        }
    }

    /**
     * 将ReentrantLock的 getQueuedThreads方法暴露出来
     */
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


        //getExclusiveOwnerThread
    }
}
