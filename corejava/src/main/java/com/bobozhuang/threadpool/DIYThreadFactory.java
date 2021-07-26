package main.java.com.bobozhuang.threadpool;

import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadFactory;

/**
 * description：
 * author Hubery
 * date 2020-11-27
 * version v0.0.1
 * since v0.0.1
 **/
public class DIYThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                LoggerFactory.getLogger(t.getName()).error(e.getMessage(), e);
            }
        });
        return t;
    }

}
