package main.java.com.bobozhuang.morethread;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * description：     任务取消　public boolean cancel(boolean mayInterruptIfRunning)
 *                      注意，取消操作不一定会起作用
 *
 *                      多次测试后发现，出现了2种打印结果:  第一种是任务压根没取消，第二种则是任务压根没提交成功。
 *
 *                      方法签名注释告诉我们，取消操作是可能会失败的，如果当前任务已经结束或者已经取消，
 *                      则当前取消操作会失败。如果任务尚未开始，那么任务不会被执行。这就解释了出现两种结果
 * author Hubery
 * date 2020-11-29
 * version v0.0.1
 * since v0.0.1
 **/
public class FutureTaskDemo5 {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        // 预创建线程
        executorService.prestartCoreThread();

        Future future = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() {
                System.out.println("start to run callable");
                Long start = System.currentTimeMillis();
                while (true) {
                    Long current = System.currentTimeMillis();
                    if ((current - start) > 1000) {
                        System.out.println("当前任务执行已经超过1s");
                        return 1;
                    }
                }
            }
        });

        Thread.currentThread().sleep(500);
        System.out.println(future.cancel(false));

        try {
            Thread.currentThread().sleep(3000);
            executorService.shutdown();
        } catch (Exception e) {
            //NO OP
        }
    }
}
