package main.java.com.bobozhuang.morethread;

import java.sql.Connection;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

/**
 * description：     改用ConcurrentHash的情况下，几乎可以避免加锁的操作，性能大大提高，
 *                  但是在高并发的情况下有可能出现Connection被创建多次的现象。这时最需要解决的问题就是当key不存在时，
 *                  创建Connection的动作能放在connectionPool之后执行，这正是FutureTask发挥作用的时机，
 *                  基于ConcurrentHashMap和FutureTask的改造代码如下：
 *
 *                  经过这样的改造，可以避免由于并发带来的多次创建连接及锁的出现
 *
 * author Hubery
 * date 2020-11-29
 * version v0.0.1
 * since v0.0.1
 **/
public class MyConnectionPool2 {

    private ConcurrentHashMap<String, FutureTask<Connection>> connectionPool = new ConcurrentHashMap<String, FutureTask<Connection>>();

    public Connection getConnection(String key) throws Exception {
        //从map中获取到的是 一个运行的FutureTask
        FutureTask<Connection> connectionTask = connectionPool.get(key);
        if (connectionTask != null) {
            return connectionTask.get();
        } else {
            Callable<Connection> callable = new Callable<Connection>() {
                @Override
                public Connection call() throws Exception {
                    // TODO Auto-generated method stub
                    return createConnection();
                }
            };
            FutureTask<Connection> newTask = new FutureTask<Connection>(callable);
            //putIfAbsent   如果传入key对应的value已经存在，就返回存在的value，不进行替换。如果不存在，就添加key和value，返回null
            connectionTask = connectionPool.putIfAbsent(key, newTask);
            //放入集合成功后 运行 FutureTask 创建链接
            if (connectionTask == null) {
                connectionTask = newTask;
                connectionTask.run();
            }
            //  返回 FutureTask执行结果
            return connectionTask.get();
        }
    }

    //创建Connection
    private Connection createConnection() {
        //创建链接的地方
        return null;
    }

}
