package main.java.com.bobozhuang.threadpool;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * description：     线程池创建线程的工厂，有两种:
 *
 *                  Executors.privilegedThreadFactory() 使用访问权限创建一个权限控制的线程。
 *                  Executors.defaultThreadFactory() 将创建一个同线程组且默认优先级的线程.
 *
 * author Hubery
 * date 2020-11-27
 * version v0.0.1
 * since v0.0.1
 **/
public class Test3 {

    public static void main(String[] args) {
        //阻塞队列，设置阻塞任务最多为10个
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(10);
        //线程工厂
//        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ThreadFactory threadFactory = Executors.privilegedThreadFactory();
        //拒绝策略 当线程池的最大工作线程跑满以及阻塞队列满了的话，会由拒绝策略处理剩下的任务
        ThreadPoolExecutor.AbortPolicy abortPolicy = new ThreadPoolExecutor.AbortPolicy();
        //创建线程池  核心线程数为5  最大线程数为10 非核心线程空闲存活时间为60s
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60L,
                TimeUnit.SECONDS, blockingQueue, threadFactory, abortPolicy
        );
        ArrayList<Callable> callables = new ArrayList<>();
        for (int i=0;i<10;i++){
            //创建10个任务，如果要是创建>20个任务，则20以外的任务会交由拒绝策略处理
            Task task = new Task("task" + i);

            //让我们自定义的线程池去跑这些任务
            threadPoolExecutor.execute(task);
        }
        //记得要关闭线程池
        threadPoolExecutor.shutdown();

    }

}
class Task implements Runnable {
    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            //模拟每个任务的耗时
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String name = Thread.currentThread().getName();
        System.out.println("这里是xhJaver，线程池系列 当前线程名字是 " + name+"  处理了  "+ taskName+"  任务");
    }
}
