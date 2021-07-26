package main.java.com.bobozhuang.Exception.threadexception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description：     一种主动方法来解决未检测异常
 *
 *                   在Thread ApI中同样提供了UncaughtExceptionHandle，它能检测出某个由于未捕获的异常而终结的情况。
 *                   这两种方法是互补的，通过将二者结合在一起，就能有效地防止线程泄露问题。
 * author Hubery
 * date 2020-11-29
 * version v0.0.1
 * since v0.0.1
 **/
public class InitiativeCaught {

    public static void main(String[] args)
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new InitiativeCaught().new InitialtiveThread());
        exec.shutdown();
    }

    public void threadDeal(Runnable r, Throwable t)
    {
        System.out.println("==Exception: "+t.getMessage());
    }

    class InitialtiveThread implements Runnable
    {
        @Override
        public void run()
        {
            Throwable thrown = null;
            try
            {
                System.out.println(3/2);
                System.out.println(3/0);
                System.out.println(3/1);
            }
            catch(Throwable e)
            {
                thrown =e;
            }
            finally{
                threadDeal(this,thrown);
            }
        }
    }

}
