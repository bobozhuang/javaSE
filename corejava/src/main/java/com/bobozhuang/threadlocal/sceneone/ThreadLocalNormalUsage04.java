package main.java.com.bobozhuang.threadlocal.sceneone;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description： 缺点：因为添加了synchronized，所以会保证同一时间只有一条线程可以执行，这在高并发场景下肯定不是一个好的选择，所以看看其他方案吧。
 *      这种方式是阻塞的。
 * author Hubery
 * date 2020-04-20
 * version v0.0.1
 * since v0.0.1
 **/
public class ThreadLocalNormalUsage04 {

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


    /**
     * 解决问题的方案：加锁，直接加对象锁
     * @param seconds
     * @return
     */
    public String date(int seconds) {

        //参数的单位是毫秒，从1970.1.1 00:00:00 GMT 开始计时
        Date date = new Date(1000 * seconds);
        String s;
        synchronized (ThreadLocalNormalUsage04.class) {
            s = dateFormat.format(date);
        }
        return s;
    }

}
