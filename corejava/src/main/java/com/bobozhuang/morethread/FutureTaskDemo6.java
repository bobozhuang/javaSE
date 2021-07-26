package main.java.com.bobozhuang.morethread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * description：     public FutureTask(Callable<V> callable)
 *                   这个是通过FutureTask的run()调用call()
 *                   public FutureTask(Runnable runnable, V result)
 *                   这个是将Runnable通过RunnableAdapter构建了一个call()
 *
 * author Hubery
 * date 2020-11-29
 * version v0.0.1
 * since v0.0.1
 **/
public class FutureTaskDemo6 {

    public static void main(String[] args) throws Exception {
        //创建线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName() + ":" + "开始烧开水...");
                // 模拟烧开水耗时
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + ":"  + "开水已经烧好了...");
                return "开水";
            }
        });
        //1线程池提交
        executor.submit(futureTask);
        //2线程启动
        Thread thread = new Thread(futureTask);
        thread.start();


        // do other thing
        System.out.println(Thread.currentThread().getName() + ":"
                + " 此时开启了一个线程执行future的逻辑（烧开水），此时我们可以干点别的事情（比如准备火锅食材）...");
        // 模拟准备火锅食材耗时
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + ":"  + "火锅食材准备好了");
        String shicai = "火锅食材";

        // 开水已经烧好，我们取得烧好的开水
        // 获取futureTask执行结果
        String boilWater = futureTask.get();

        System.out.println(Thread.currentThread().getName() + ":"  + boilWater + "和" + shicai + "已经准备好，我们可以开始打火锅啦");
    }
}
