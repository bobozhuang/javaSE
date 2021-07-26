package main.java.com.bobozhuang.morethread.forkjoinpool.service;

/**
 * description：
 * author Hubery
 * date 2020-09-28
 * version v0.0.1
 * since v0.0.1
 **/
public interface Calculator {

    /**
     * 把传进来的所有numbers 做求和处理
     * @param numbers
     * @return
     */
    long sumUp(long[] numbers);

}
