package main.java.com.bobozhuang.Exception.threadexception;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * description：
 * author Hubery
 * date 2020-11-29
 * version v0.0.1
 * since v0.0.1
 **/
public class ExecuteCaught3 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        //exec.execute(new ThreadPoolTask());
        //这样就变成 阻塞的了
        Future<?> submit = exec.submit(new ThreadPoolTask());
        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        exec.shutdown();


    }

}
