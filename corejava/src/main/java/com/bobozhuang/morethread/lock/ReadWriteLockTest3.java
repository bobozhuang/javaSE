package main.java.com.bobozhuang.morethread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * description： ReentrantReadWriteLock是不支持的。
 * author Hubery
 * date 2020-09-29
 * version v0.0.1
 * since v0.0.1
 **/
public class ReadWriteLockTest3 {

    public static void main(String[] args) {
        down();
        up();

    }

    /**
     * 锁升级，ReentrantReadWriteLock是不支持的。
     */
    public static void up(){

        ReentrantReadWriteLock rtLock = new ReentrantReadWriteLock();
        rtLock.readLock().lock();
        System.out.println("get readLock.");
        rtLock.writeLock().lock();
        System.out.println("blocking");
    }

    /**
     * ReentrantReadWriteLock支持锁降级
     */
    public static void down(){
        ReentrantReadWriteLock rtLock = new ReentrantReadWriteLock();
        rtLock.writeLock().lock();
        System.out.println("writeLock");

        rtLock.readLock().lock();
        System.out.println("get read lock");
    }
}
