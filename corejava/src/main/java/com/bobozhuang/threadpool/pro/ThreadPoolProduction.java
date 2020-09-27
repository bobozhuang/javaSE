package main.java.com.bobozhuang.threadpool.pro;

import main.java.com.bobozhuang.threadpool.pro.impl.BussinessServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * description：如何使用 threadpool的demo，实际开发不通过 executors创建线程池
 * author Hubery
 * date 2020-04-02
 * version v0.0.1
 * since v0.0.1
 **/
public class ThreadPoolProduction {
    public static void main(String[] args) {

        BussinessService bussinessService = new BussinessServiceImpl();

        //1.新建一个线程池，池中有两个线程，注意这里使用的是fiexd 注意和cached的区别
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //2.
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        //3.
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //4.
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        //注意这里使用的是callable 而不是runable。
        ArrayList<Callable<Integer>> tasks = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            tasks.add(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    bussinessService.handleBussiness();
                    return 0;
                }
            });
        }

        try {
            //由于我们使用的是callable，所以在执行完成后，会拿到反馈信息，而runable不可以
            List<Future<Integer>> futures = executorService.invokeAll(tasks);
            for (Future<Integer> future : futures) {
                System.out.println(future.get());
            }
        } catch (ExecutionException e) {
            //这里生产环境不可以这么写，不要生吞(swallow)异常，处理的方式有很多种，比如可以向日志系统追加日志
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

    }
}
