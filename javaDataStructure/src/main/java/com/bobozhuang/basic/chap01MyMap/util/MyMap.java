package main.java.com.bobozhuang.basic.chap01MyMap.util;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:
 * @date: 2019/4/21 12:08
 * @Package main.java.com.bobozhuang.basic.chap01MyMap.util
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public interface MyMap<K,V> {
    //向集合中插入值
    public V put(K k,V v);
    //根据集合中的key获取集合中的值
    public V get(K k);
    //获取集合中的元素
    public int size();
    //用于获取集合中的，键值对的对象
    interface Entry<K,V>{
        K getKey();
        V getValue();
        V setValue(V value);
        Entry<K,V> getNext();
        Entry<K,V> setNext(Entry<K,V> next);
    }



}
