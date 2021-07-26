package main.java.com.bobozhuang.morethread.threadstatus;

import java.util.concurrent.locks.LockSupport;

/**
 * description：查看线程状态
 * author Hubery
 * date 2020-11-16
 * version v0.0.1
 * since v0.0.1
 **/
public class WaitTest4 {

    public static void main(String[] args) throws InterruptedException {
        //test1();
        //test2();
        test3();

        //Thread t = new YieldThread();
    }

    static void test1() throws InterruptedException {
        //Thread t = new WaitThread1();
        //Thread t = new WaitThread2();
        //Thread t = new SleepThread();
        Thread t = new ParkThread();
        t.start();
        System.out.println(t.getName() + ": " + t.getState());
        Thread.sleep(100);
        System.out.println(t.getName() + ": " + t.getState());
        System.out.println("-----------------");
    }

    static void test2() throws InterruptedException {
        Thread t1 = new BlockedThread();
        Thread t2 = new BlockedThread();
        t1.start();
        Thread.sleep(100);
        System.out.println(t1.getName() + ": " + t1.getState());
        t2.start();
        Thread.sleep(100);
        System.out.println(t2.getName() + ": " + t2.getState());
    }

    static void test3() throws InterruptedException {
        Thread t = new JoinThread();
        Thread t1 = new JoinThread(t);
        t.start();
        t1.start();
        Thread.sleep(100);
        System.out.println(t.getName() + ": " + t.getState());

    }
}

class WaitThread1 extends Thread {
    String str = "a";

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        synchronized (str) {
            try {
                if (str == "a"){
                    str.wait();
                }else {
                    str.notify();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class WaitThread2 extends Thread {
    String str = "";

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        synchronized (str) {
            try {
                str.wait(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SleepThread extends Thread {
    String str = "";
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class JoinThread extends Thread {
    public Thread t;

    public JoinThread() {
    }

    public JoinThread(Thread t) {
        this.t = t;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        if (t != null) {
            try {

                t.join();//这个没有测出来
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
                String name = Thread.currentThread().getName();
                System.out.println(name + ":" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class BlockedThread extends Thread {
    String str = "";
    @Override
    public void run() {
        synchronized (str){
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ParkThread extends Thread {
    @Override
    public void run() {
        long l = System.currentTimeMillis();
        LockSupport.parkNanos(1000 * 1000000 * 1000000 * 1000000);
        //LockSupport.park();     //WAITING
        //LockSupport.park();
        long l1 = System.currentTimeMillis()-l;
        System.out.println(Thread.currentThread().getName() + "  :parkend : " + l1);
    }
}

class YieldThread extends Thread {
    @Override
    public void run() {
        super.run();
    }
}