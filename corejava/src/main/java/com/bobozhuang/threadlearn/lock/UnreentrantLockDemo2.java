package lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * description： 不可重入 变得可重入  就是当前线程现在获取到了锁，在次加锁的时候当前线程还能获取到锁
 * author Hubery
 * date 2020-09-03
 * version v0.0.1
 * since v0.0.1
 **/
public class UnreentrantLockDemo2 {

    private AtomicReference<Thread> owner = new AtomicReference<Thread>();
    private int state = 0;
    public void lock() {
        Thread current = Thread.currentThread();
        //在执行每次操作之前，判断当前锁持有者是否是当前对象，采用state计数，不用每次去释放锁
        if (current == owner.get()) {       //这里就会解决 不可重入导致的死锁，通过判断是当前线程就累加一次，不需要等到锁释放
            state++;
            return;
        }
        //这句是很经典的“自旋”式语法，AtomicInteger中也有
        for (;;) {
            if (!owner.compareAndSet(null, current)) {
                return;
            }
        }
    }
    public void unlock() {
        Thread current = Thread.currentThread();
        if (current == owner.get()) {
            if (state != 0) {
                state--;
            } else {
                owner.compareAndSet(current, null);
            }
        }
    }
}
