package main.java.com.bobozhuang.morethread.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * description： 使用自旋锁来模拟一个不可重入锁
 *          使用原子引用来存放线程，同一线程两次调用lock()方法，如果不执行unlock()释放锁的话，第二次调用自旋的时候就会产生死锁，
 *          这个锁就不是可重入的，而实际上同一个线程不必每次都去释放锁再来获取锁，这样的调度切换是很耗资源的。
 *
 * author Hubery
 * date 2020-09-03
 * version v0.0.1
 * since v0.0.1
 **/
public class UnreentrantLockDemo1 {

    private AtomicReference<Thread> owner = new AtomicReference<Thread>();
    public void lock() {
        Thread current = Thread.currentThread();
        //这句是很经典的“自旋”语法，AtomicInteger中也有
        for (;;) {
            if (!owner.compareAndSet(null, current)) {
                return;
            }
        }
    }
    public void unlock() {
        Thread current = Thread.currentThread();
        owner.compareAndSet(current, null);
    }

}
