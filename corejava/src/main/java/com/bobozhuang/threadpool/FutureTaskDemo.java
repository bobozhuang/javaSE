package main.java.com.bobozhuang.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * description：
 * author Hubery
 * date 2020-03-22
 * version v0.0.1
 * since v0.0.1
 **/
public class FutureTaskDemo {
    public static void main(String[] args) {

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.printf("hello world !");
                return "个人博客：sunfusheng.com";
            }
        };

        FutureTask<String> task = new FutureTask<String>(callable);

        Thread t = new Thread(task);
        t.start(); // 启动线程
        task.cancel(true); // 取消线程


    }
}
