package main.java.com.bobozhuang.threadlocal.sceneone;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description： 使用线程池时就会发现每个线程都有一个自己的SimpleDateFormat对象，没有必要，所以将SimpleDateFormat声明为静态，保证只有一个
 *  1000个线程打印日期，用线程池来执行，出现线程安全问题
 *  原因：多个线程的task指向了同一个SimpleDateFormat对象，SimpleDateFormat是非线程安全的。
 * author Hubery
 * date 2020-04-20
 * version v0.0.1
 * since v0.0.1
 **/
public class ThreadLocalNormalUsage03 {

    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    //只创建一次 SimpleDateFormat 对象，避免不必要的资源消耗   虽然避免每个线程创建对象资源消耗，但是随之而来的并发问题出现。
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            //提交任务
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalNormalUsage03().date(finalI);
                    System.out.println(date);
                }
            });
        }
        threadPool.shutdown();
    }

    public String date(int seconds) {

        //参数的单位是毫秒，从1970.1.1 00:00:00 GMT 开始计时
        Date date = new Date(1000 * seconds);
        return dateFormat.format(date);
    }

}
