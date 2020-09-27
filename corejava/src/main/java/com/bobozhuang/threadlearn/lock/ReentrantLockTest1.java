package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * description:     重入锁
 * author Hubery
 * date 2019-10-21
 * version v0.0.1
 * since v0.0.1
 **/
public class ReentrantLockTest1 {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        for (int i = 1; i <= 3; i++) {
            lock.lock();
            System.out.println("lock : " + i);
        }

        for (int i = 1; i <= 3; i++) {
            try {
                System.out.println("unlock: " + i);
            } finally {
                lock.unlock();
            }
        }
        System.out.println(" ---- ");
        ReentrantLockTest1 reentrantLockTest1 = new ReentrantLockTest1();
        reentrantLockTest1.setB();
        reentrantLockTest1.setA();

    }

    /**
     * 可重入锁是    在外层使用锁之后，在内层仍然可以使用,如果setB再调用setA就会死锁
     */
    synchronized void setA() {
        try {
            System.out.println("A" + Thread.currentThread());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setB();//要等B睡醒
    }

    synchronized void setB() {
        try {
            System.out.println("B" + Thread.currentThread());
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //setA();
    }


}
