package main.java.com.bobozhuang.morethread.threadstatus;

import java.util.concurrent.locks.LockSupport;

/**
 * description： park方法不会抛出InterruptedException，但是它也会响应中断。当外部线程对阻塞线程调用interrupt方法时，
 *              park阻塞的线程也会立刻返回。只要中断标志不清除，park永远会响应中断。不会像sleep响应中断之后会清除中断标志
 *
 * author Hubery
 * date 2020-12-01
 * version v0.0.1
 * since v0.0.1
 **/
public class ParkTest3 {

    public static volatile boolean flag = true;
    public static void main(String[] args) {
        ThreadDemo04 t4 = new ThreadDemo04();
        t4.start();
        t4.interrupt();
        flag = false;
    }
    public static class ThreadDemo04 extends Thread {
        @Override
        public void run() {
            while (flag) {
            }
            LockSupport.park();
            System.out.println("本打印出现在第一个park()之后");
            LockSupport.park();
            System.out.println("本打印出现在第二个park()之后");
        }
    }
}
