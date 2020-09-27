package threadstatus;

import java.util.concurrent.locks.LockSupport;

/**
 * description：
 * author Hubery
 * date 2020-09-22
 * version v0.0.1
 * since v0.0.1
 **/
public class ParkTest2 {

    public static void main(String[] args) {

        Thread parkThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("park begin");

                //等待获取许可
                LockSupport.park();
                //输出thread over.true
                System.out.println("thread over." + Thread.currentThread().isInterrupted());

            }
        });
        parkThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 中断线程
        parkThread.interrupt();

        System.out.println("main over");

    }
}
