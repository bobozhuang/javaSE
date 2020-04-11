package main.java.com.bobozhuang.timer.twolevel;

/**
 * description：
 * author Hubery
 * date 2020-03-31
 * version v0.0.1
 * since v0.0.1
 **/
public interface Server {
    void start();

    void restart();

    void shutdown();

    boolean isAlive();
}