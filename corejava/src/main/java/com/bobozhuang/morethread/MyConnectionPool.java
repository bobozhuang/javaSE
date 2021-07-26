package main.java.com.bobozhuang.morethread;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description：         高并发的环境下，往往我们只需要某些任务只执行一次。这种使用情景FutureTask的特性恰能胜任。
 *                      举一个例子，假设有一个带key的连接池，当key存在时，即直接返回key对应的对象；当key不存在时，则创建连接。
 *                      对于这样的应用场景，通常采用的方法为使用一个Map对象来存储key和连接池对应的对应关系，典型的代码如下面所示：
 *
 *                      通过加锁确保高并发环境下的线程安全，也确保了connection只创建一次，然而确牺牲了性能
 *
 *                      https://cloud.tencent.com/developer/article/1041329
 * author Hubery
 * date 2020-11-29
 * version v0.0.1
 * since v0.0.1
 **/
public class MyConnectionPool {


    private Map<String, Connection> connectionPool = new HashMap<String, Connection>();
    private ReentrantLock lock = new ReentrantLock();

    public Connection getConnection(String key) {
        try {
            lock.lock();
            if (connectionPool.containsKey(key)) {
                return connectionPool.get(key);
            } else {
                //创建 Connection
                Connection conn = createConnection();
                connectionPool.put(key, conn);
                return conn;
            }
        } finally {
            lock.unlock();
        }
    }

    //创建Connection
    private Connection createConnection() {
        return null;
    }
}
