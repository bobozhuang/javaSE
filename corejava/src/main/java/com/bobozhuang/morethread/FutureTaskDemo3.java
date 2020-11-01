package main.java.com.bobozhuang.morethread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * description： 看一个等待、获取任务执行结果
 *
 *          Future 接口包含 5 个方法:
 *              boolean cancel(boolean mayInterruptIfRunning);//取消任务
 *              boolean isCancelled();//判断任务是否已取消
 *              boolean isDone();//判断任务是否已结束
 *              get();//获得任务执行结果
 *              get(long timeout, TimeUnit unit);//获得任务执行结果，支持超时
 *
 *          Future 对象是由 ExecutorService 接口的 3 个提交任务的方法返回
 *              Future<?> submit(Runnable task);//提交 Runnable 任务
 *              <T> Future<T> submit(Callable<T> task);//提交 Callable 任务
 *              <T> Future<T> submit(Runnable task, T result);//提交 Runnable 任务及结果引用，result 用于主线程和任务执行线程间通信
 *              这个接口是这样用的：Runnable没有返回值，但是有了这个方法就会有返回值了
 *
 *              Runnable不会返回任何内容，Future必须返回一些内容，因此此方法允许您预定义返回的未来的结果。
 *              如果你不想返回一个东西，你可以返回null，我认为存在Void类型来表达那种东西。
 *
 *
 * author Hubery
 * date 2020-09-26
 * version v0.0.1
 * since v0.0.1
 **/
public class FutureTaskDemo3 {
    private static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //去除 Helle 2020 空格，判断任务执行状态，输出等待信息
        Future<String> future = removeBlank("Helle 2020");
        while (!future.isDone()) {// isDone() 方法可以判断任务是否已经执行完成
            Thread.sleep(1000L);
            System.out.println("等待1秒");
        }
        System.out.println(future.get());   //get() 方法可以获取到任务的执行结果
        executor.shutdown();
    }

    /**
     * 移除字符串中的空白符号
     * @param str
     * @return
     */
    private static Future<String> removeBlank(String str) {
        return executor.submit(() -> {
            Thread.sleep(3000L);
            return str.replace(" ", "");
        });
    }

}
