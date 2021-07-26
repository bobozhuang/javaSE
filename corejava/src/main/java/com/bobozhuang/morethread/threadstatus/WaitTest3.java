package main.java.com.bobozhuang.morethread.threadstatus;

/**
 * description：
 * author Hubery
 * date 2020-09-23
 * version v0.0.1
 * since v0.0.1
 **/
public class WaitTest3 {

    public static void main(String[] args) {
        Object waitObject = new Object();


        try {
            //先获取到waitObject的锁
            synchronized (waitObject) {
                waitObject.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized(waitObject){
            waitObject.notifyAll();
        }


        try {
            //没获取到waitObject的锁，调用该方法抛出IllegalMonitorStateException异常
            waitObject.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
