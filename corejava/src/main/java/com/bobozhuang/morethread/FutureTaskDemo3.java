package main.java.com.bobozhuang.morethread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * description： 看一个等待、获取任务执行结果
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
        while (!future.isDone()) {
            Thread.sleep(1000L);
            System.out.println("等待1秒");
        }
        System.out.println(future.get());
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
