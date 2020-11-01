package main.java.com.bobozhuang.morethread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * description：
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
 * author Hubery
 * date 2020-09-28
 * version v0.0.1
 * since v0.0.1
 **/
public class FutureTaskDemo4 {

    private static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws Exception {
        testGetReplaceBlankWithResult();
    }

    private static void testGetReplaceBlankWithResult() throws Exception {
        //用 Result 对象里的 str 字符串替换 Helle 2020 中的空格
        Result r = new Result(" ConstXiong ");
        Future<String> future = replaceBlank("Helle 2020", r);
        System.out.println(future.get());
        System.out.println(r.getStr());
        executor.shutdown();
    }

    /**
     * 根据 Result 对象的 str 属性替换目标字符串中的空格，并且修改 Result 对象的 str
     * @param str
     * @return
     */
    private static Future<String> replaceBlank(String str, Result result) {
        return executor.submit(() -> {
            Thread.sleep(3000L);
            String newStr = str.replace(" ", result.getStr());
            result.setStr("大俊子");
            return newStr;
        });
    }

    private static void replaceBlank2() {
        final String[] mutable = new String[1];
        Runnable r = new Runnable() {
            public void run() {
                mutable[0] = "howdy";
            }
        };
        Future<String[]> f = executor.submit(r, mutable);
        String[] result = new String[0];
        try {
            result = f.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("result[0]: " + result[0]);
    }

}

class Result {

    private String str;

    public Result(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }


}
