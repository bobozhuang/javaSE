package main.java.com.bobozhuang.threadpool;

import java.util.concurrent.*;

/**
 * description：
 * author Hubery
 * date 2020-11-25
 * version v0.0.1
 * since v0.0.1
 **/
public class Test2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //test1();
//        test2();
        test3();

    }

    /**
     * 它也仅仅是输出而已，我们无法使用logback之类的日志框架对其进行记录，因为它这个打印动作我们是不可控的。
     */
    public static void test1() {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Runnable r = () -> System.out.println(1 / 0);
        service.execute(r);
        service.shutdown();
    }

    public static void test2() {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Runnable r = () -> System.out.println(1 / 0);
        Future f = service.submit(r);
        try {
            f.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

    public static void test3() {

        ThreadFactory factory = r -> {
            Thread thread = Executors.defaultThreadFactory().newThread(r);
            thread.setUncaughtExceptionHandler((t, e) -> {
                System.out.println(t + "=====" + e);//这个t是线程类对象
                e.printStackTrace();
                System.out.println("-----" + e.getMessage());
                System.out.println(t + "-----" + t.getName());
            });
            return thread;
        };

        ExecutorService service = Executors.newFixedThreadPool(1, factory);
        Runnable r = () -> {
            System.out.println("a");
            System.out.println(1 / 0);
        };

        service.execute(r);
        service.shutdown();

    }
}
