package main.java.com.bobozhuang.morethread.threadstatus;

import java.util.concurrent.locks.LockSupport;

/**
 * description：     park()阻塞当前线程，如果调用unpark(Thread)或者当前线程被中断，才能从park()方法返回
 * unpark(Thread)取消阻塞
 * <p>
 * 先调用unpark方法释放一个许可证，这样后面线程调用park方法时，发现已经有许可证了，
 * 就可以直接获取许可证而不用进入休眠状态
 * <p>
 * author Hubery
 * date 2020-09-10
 * version v0.0.1
 * since v0.0.1
 **/
public class ParkTest1 {

    public static void main(String[] args) {
        test();
        //test2();
        //test3();
    }

    /**
     * unpark(Thread)方式取消阻塞
     */
    public static void test() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("------start-------");
                LockSupport.park();
                System.out.println("------end-------");
            }
        });

        thread.start();
        try {
            Thread.sleep(1000l);
            System.out.println("sleep1S");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LockSupport.unpark(thread);
    }

    /**
     * 通过
     */
    public static void test2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("------start-------");
                LockSupport.park();
                System.out.println("------end-------");
            }
        });

        thread.start();
        try {
            System.out.println("sleep前");
            thread.sleep(1000l);    //sleep不会取消阻塞，调用interrupt取消阻塞，所以不会抛异常
            System.out.println("sleep后");
        } catch (InterruptedException e) {

            System.out.println("sleep后唤醒");
            e.printStackTrace();
        }
    }

    public static void test3() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("------start-------");
                LockSupport.park();
                System.out.println("------end-------");
            }
        });

        thread.start();
        thread.interrupt();//设置中断标志 的同时会取消阻塞
        //复习一下interrupt
        //isInterrupted()只会返回中断标志，不会取消中断
        boolean interrupted1 = thread.isInterrupted();
        System.out.println("调用了1isInterrupted() " + interrupted1);

        boolean interrupted2 = thread.isInterrupted();
        System.out.println("调用了2isInterrupted() " + interrupted2);
        //interrupted()这个在这种场景不会清除中断标志  和阻塞没有关系
        boolean interrupted3 = thread.interrupted();    //但是会返回false

        System.out.println("调用了interrupted() " + interrupted3);
        // 返回true，主线程没有结束就
        boolean interrupted4 = thread.isInterrupted();
        System.out.println("调用了3isInterrupted() " + interrupted4);
    }

    /**
     *  调用interrupt()方法会取消阻塞
     */
    public static void test4() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("------start-------");
                LockSupport.park();
                System.out.println("------end-------");
            }
        });

        thread.start();
        thread.interrupt();//设置中断标志
        System.out.println("s前");

    }
}
