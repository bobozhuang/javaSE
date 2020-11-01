package lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * description：     从运行结果中，可以看到，程序并未执行线程的run方法，由此可知代码会出现死锁，
 *          因为主线程2次获取了锁，但是却只释放1次锁，导致线程t永远也不能获取锁。一个线程获取多少次锁，就必须释放多少次锁。
 *          这对于内置锁也是适用的，每一次进入和离开synchornized方法(代码块)，就是一次完整的锁获取和释放。
 *
 * author Hubery
 * date 2020-09-29
 * version v0.0.1
 * since v0.0.1
 **/
public class ReadWriteLockTest2 {

    public static void main(String[] args) throws InterruptedException {
        final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.writeLock().lock();
                System.out.println("Thread real execute");
                lock.writeLock().unlock();
            }
        });

        lock.writeLock().lock();
        lock.writeLock().lock();
        t.start();
        Thread.sleep(200);

        System.out.println("realse one once");
        lock.writeLock().unlock();
    }

}
