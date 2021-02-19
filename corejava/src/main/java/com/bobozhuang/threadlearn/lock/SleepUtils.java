package main.java.com.bobozhuang.threadlearn.lock;

/**
 * description：
 * author Hubery
 * date 2020-09-01
 * version v0.0.1
 * since v0.0.1
 **/
public class SleepUtils {
    public static void sleep(int time) {
        Thread thread = Thread.currentThread();
        try {
            System.out.println("currentThread " + thread + " time " +time);
            thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
