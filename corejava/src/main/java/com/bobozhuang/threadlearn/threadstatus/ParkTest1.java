package threadstatus;

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

        test3();
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
        thread.interrupt();//设置中断标志
        try {
            System.out.println("sleep前");
            Thread.sleep(1000l);    //sleep的同时会取消阻塞
            System.out.println("sleep后");
        } catch (InterruptedException e) {
            //sleep后唤醒          尽然不执行这里，说明sleep会唤醒阻塞的线程,并且正常sleep
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
        System.out.println("调用了isInterrupted() " + interrupted1);

        boolean interrupted2 = thread.isInterrupted();
        System.out.println("调用了isInterrupted() " + interrupted2);
        //interrupted()这个会清除中断标志  但是和阻塞没有关系
        boolean interrupted3 = thread.interrupted();    //但是会返回false

        System.out.println("调用了interrupted() " + interrupted3);


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
