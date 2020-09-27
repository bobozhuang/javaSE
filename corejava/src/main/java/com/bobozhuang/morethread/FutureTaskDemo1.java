package main.java.com.bobozhuang.morethread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * description：
 * author Hubery
 * date 2020-03-22
 * version v0.0.1
 * since v0.0.1
 **/
public class FutureTaskDemo1 {

    public static void main(String[] args) {

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("hello world !");
                return "com";
            }
        };

        FutureTask<String> task = new FutureTask<String>(callable);

        Thread t = new Thread(task);
        t.start(); // 启动线程
        String s = "";
        try {
            s = task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("back: " + s);
        task.cancel(true); // 取消线程


    }
}
