package main.java.com.bobozhuang.threadpool.pro.impl;

import main.java.com.bobozhuang.threadpool.pro.BussinessService;

import java.util.concurrent.locks.Lock;

/**
 * description：
 * author Hubery
 * date 2020-04-02
 * version v0.0.1
 * since v0.0.1
 **/
public class BussinessServiceImpl implements BussinessService {

    @Override
    public void handleBussiness() {
        System.out.println("处理业务逻辑");

        // 为了观察线程是根据线程池设置的线程数，批量执行的，这里加上线程休眠
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
