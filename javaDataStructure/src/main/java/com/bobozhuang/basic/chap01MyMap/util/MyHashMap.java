package main.java.com.bobozhuang.basic.chap01MyMap.util;


/**
 * @version V1.0
 * @author: Hubery
 * @Description:
 * @date: 2019/4/21 12:17
 * @Package main.java.com.bobozhuang.basic.chap01MyMap.util
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class MyHashMap<K, V> implements MyMap<K, V> {

    //Entry类型数组 默认长度 16,用来存数据
    private Entry<K, V> table[] = null;
    //HashMap元素的个数
    private int size;
    //HashMap的默认长度
    private static int defaultLength = 16;
    //定义加载因子

    @Override
    public V put(K k, V v) {
        if (null == table) {
            table = new Entry[this.defaultLength];
        }
        //  1、确定table中下标
        int index = getIndex(k, this.defaultLength);
        //  2、创建Entry元素存放在table中
        table[index] = new Entry<>(k, v, table[index]);
        this.size++;
        return v;
    }

    private int getIndex(K k, int length) {
        if (null == k) {
            return 0;
        }
        int index = k.hashCode();
        return index & (length - 1);
    }

    @Override
    public V get(K k) {
        if (null != table) {
            int index = getIndex(k, this.defaultLength);
            MyMap.Entry<K, V> kvEntry = table[index];
            while (null != kvEntry) {
                if (k.equals(kvEntry.getKey())) {
                    return kvEntry.getValue();
                } else {
                    kvEntry = kvEntry.getNext();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    static class Entry<K, V> implements MyMap.Entry<K, V> {

        K key;
        V value;
        MyMap.Entry<K, V> next;

        /**
         * 构造器
         *
         * @param key
         * @param value
         * @param next
         */
        public Entry(K key, V value, MyMap.Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public MyMap.Entry<K, V> getNext() {
            return this.next;
        }

        @Override
        public MyMap.Entry<K, V> setNext(MyMap.Entry<K, V> next) {
            MyMap.Entry<K, V> oldNext = this.next;
            this.next = next;
            return oldNext;
        }
    }
}
