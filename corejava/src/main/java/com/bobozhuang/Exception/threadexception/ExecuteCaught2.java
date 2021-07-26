package main.java.com.bobozhuang.Exception.threadexception;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * description：     将异常的捕获封装到Runnable或者Callable中,且只有通过execute提交的任务，才能将它抛出的异常
 *                      交给UncaughtExceptionHandler
 *
 *                     而通过submit提交的任务，
 * *                   无论是抛出的未检测异常还是已检查异常，都将被认为是任务返回状态的一部分。如果一个由submit提交的任务由于
 * *                   抛出了异常而结束，那么这个异常将被Future.get封装在ExecutionException中重新抛出。
 * author Hubery
 * date 2020-11-29
 * version v0.0.1
 * since v0.0.1
 **/
public class ExecuteCaught2 {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ThreadPoolTask());
        exec.shutdown();

    }
}

class ThreadPoolTask implements Runnable {
    @Override
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
        System.out.println(3 / 2);
        System.out.println(3 / 0);
        System.out.println(3 / 1);
    }

}
