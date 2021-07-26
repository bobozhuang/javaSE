package main.java.com.bobozhuang.Exception.threadexception;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description：     用线程池通过execute的方法去捕获异常 ,可以看到并未捕获到异常，如果捕获到了会打印e.getMessage
 *
 *
 * author Hubery
 * date 2020-11-29
 * version v0.0.1
 * since v0.0.1
 **/
public class ExecuteCaught {

    public static void main(String[] args)
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(4/0);
            }
        });
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        exec.execute(thread);
        exec.shutdown();
        //可以看到并未捕获到异常，如果捕获到了会打印e.getMessage
    }


}
