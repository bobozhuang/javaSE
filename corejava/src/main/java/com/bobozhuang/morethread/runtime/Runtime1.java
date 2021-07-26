package main.java.com.bobozhuang.morethread.runtime;

import java.util.concurrent.ForkJoinPool;

/**
 * description：
 *              我这台mac是双核4线程所以会返回8
 *              将线程池的线程数设为16，如果代码的瓶颈是在CPU这块的话，我会有16个线程在同时 竞争CPU周期，而不是更合理的8个线程。
 *              如果我的瓶颈是在内存这的话，那我可以获得8个线程的性能提升。
 * author Hubery
 * date 2020-09-28
 * version v0.0.1
 * since v0.0.1
 **/
public class Runtime1 {

    public static void main(String[] args) {

        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
        new ForkJoinPool();
    }
}
