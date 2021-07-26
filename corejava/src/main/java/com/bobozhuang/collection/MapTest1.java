package main.java.com.bobozhuang.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * description：         map 也有拷贝问题
 * author Hubery
 * date 2020-05-12
 * version v0.0.1
 * since v0.0.1
 **/
public class MapTest1 {

    //HashMap hashMap = new HashMap();
    //Collections

    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("a",1);
        m.put("b",2);
        Map n = new HashMap();
        //这里 = 直接赋值，add添加都是浅拷贝，只要修改集合的值，两个集合都会变的
        //n = m;
        n.putAll(m);

        System.out.println(n);
        m.put("c",3);
        System.out.println(m);
        System.out.println(n);
    }



}
