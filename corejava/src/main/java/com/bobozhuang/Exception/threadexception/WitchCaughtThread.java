package main.java.com.bobozhuang.Exception.threadexception;

/**
 * description：
 * author Hubery
 * date 2020-11-29
 * version v0.0.1
 * since v0.0.1
 **/
public class WitchCaughtThread {

    public static void main(String args[])
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(5/0);
            }
        });
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();

        //同样可以为所有的Thread设置一个默认的UncaughtExceptionHandler，
        //通过调用Thread.setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler eh)方法，这是Thread的一个static方法。
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
    }
}

class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e)
    {
        System.out.println("==Exception: "+e.getMessage());
        e.printStackTrace();
        //System.out.println();
    }


}
