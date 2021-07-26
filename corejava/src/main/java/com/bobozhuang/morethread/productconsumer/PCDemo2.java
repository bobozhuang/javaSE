package main.java.com.bobozhuang.morethread.productconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description：     ReetrantLock+Condition
 * author Hubery
 * date 2020-12-09
 * version v0.0.1
 * since v0.0.1
 **/
public class PCDemo2 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        List list = new ArrayList();
        Product2 product2 = new Product2(list, lock, lock.newCondition());
        Consumer2 consumer2 = new Consumer2(list);
        Thread tp = new Thread(product2);
        tp.start();
        Thread tc = new Thread(consumer2);
        tc.start();
    }
}

class Product2 implements Runnable {
    private List list;
    private Lock mLock;
    private Condition mCondition;
    private int num = 1;

    public Product2(List list, Lock lock, Condition condition) {
        this.list = list;
        this.mLock = lock;
        this.mCondition = condition;
    }

    //一个生产者对应一个消费者
    @Override
    public void run() {

        while (true) {
            mLock.lock();
            if (list.size() > 0) {
                //集合中有数据就停止写入，等待消费者消费完
                try {
                    mCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //执行到这说明集合没有数据了
            list.add(num);
            //提示
            System.out.println(Thread.currentThread().getName() + "线程生产了：" + list.get(0));
            mCondition.signalAll();
            mLock.unlock();
            System.out.println("product release lock");
        }
    }
}

class Consumer2 implements Runnable {
    private List list;

    public Consumer2(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            //System.out.println("start consumer ");
            synchronized (list) {
                /*while (list.size() <= 0) {//适合多生产者多消费者
                    try {
                        list.wait();
                        System.out.println("wait release lock");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
*/

                //提示
                if (list.size()>0){
                    System.err.println(Thread.currentThread().getName() + "线程消费了：" + list.remove(0));
                }

                list.notifyAll();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}