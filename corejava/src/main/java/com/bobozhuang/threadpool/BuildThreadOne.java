package main.java.com.bobozhuang.threadpool;

/**
 * description：
 * author Hubery
 * date 2020-03-21
 * version v0.0.1
 * since v0.0.1
 **/
public class BuildThreadOne {
    public static void main(String[] args) {
        DemoThread t = new DemoThread();
        t.start();
    }
}
class DemoThread extends Thread {

    @Override
    public void run() {
        //super.run();
        // Perform time-consuming operation...
        System.out.printf("ddddd中文");
    }
}

