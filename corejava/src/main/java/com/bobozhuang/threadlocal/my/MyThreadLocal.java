package main.java.com.bobozhuang.threadlocal.my;

import java.util.HashMap;

/**
 * description：
 * author Hubery
 * date 2020-05-07
 * version v0.0.1
 * since v0.0.1
 **/
public class MyThreadLocal<T> {

    // 共享空间
    static HashMap<Thread, HashMap<MyThreadLocal<?>, Object>> threadLocalMap = new HashMap<>();

    // 临界区

    /**
     * 获取当前线程的数据
     * @return
     */
    synchronized static HashMap<MyThreadLocal<?>, Object> getMap() {
        // 获取当前线程
        Thread thread = Thread.currentThread();
        // 判断threadLocalMap是否包含当前线程，不包含就put进去
        if (!threadLocalMap.containsKey(thread)) {
            threadLocalMap.put(thread, new HashMap<MyThreadLocal<?>,Object>());
        }
        // 获取当前thread的map
        return threadLocalMap.get(thread);
    }

    protected T initialValue() {
        return null;
    }

    public T get() {
        HashMap<MyThreadLocal<?>, Object> map = getMap();
        if (!map.containsKey(this)) {
            map.put(this, initialValue());
        }
        return (T) map.get(this);
    }

    public void set(T v) {
        HashMap<MyThreadLocal<?>, Object> map = getMap();
        map.put(this, v);
    }
}
