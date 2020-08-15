package main.java.com.bobozhuang.exam.chap01;

import java.util.HashMap;
import java.util.Map;

/**
 * description：
 * author Hubery
 * date 2020-08-05
 * version v0.0.1
 * since v0.0.1
 **/
public class Maptest {

    public static void main(String[] args) {
        String string = null;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("aa","a");
        hashMap.put("bb",string);
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
    }
}
