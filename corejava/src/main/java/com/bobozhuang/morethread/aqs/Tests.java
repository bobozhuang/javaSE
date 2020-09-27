package main.java.com.bobozhuang.morethread.aqs;

/**
 * description： JDK 本身提供的 synchronized 关键字配合实现的等待/通知机制。
 *
 *      我们开始来学习 AQS 是如何来实现等待/通知机制的！
 *
 * author Hubery
 * date 2020-09-23
 * version v0.0.1
 * since v0.0.1
 **/
public class Tests {
    public static void main(String[] args) throws InterruptedException {
        Tests tests = new Tests();

        new Thread(tests::waits).start();
        //让上面的线程先睡觉完毕
        Thread.sleep(1000);
        new Thread(tests::notifys).start();
    }

    //随便构建一个对象，用来当锁对象
    private final Object object = new Object();

    //等待的方法
    private void waits() {
        synchronized (object) {
            try {
                System.out.println("开始睡觉！");
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我被唤醒啦");
        }
    }

    //唤醒方法
    private void notifys() {
        synchronized (object) {
            System.out.println("开始唤醒啦");
            object.notifyAll();
        }
    }

}
