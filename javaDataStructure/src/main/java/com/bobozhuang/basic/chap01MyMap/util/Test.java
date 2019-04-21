package main.java.com.bobozhuang.basic.chap01MyMap.util;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:
 * @date: 2019/4/21 14:31
 * @Package main.java.com.bobozhuang.basic.chap01MyMap.util
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Test {
    public static void main(String[] args) {
        MyMap<String,String> myMap = new MyHashMap<String, String>();
        myMap.put("1号","王师傅");
        myMap.put("2号","王师傅");
        myMap.put("3号","王师傅");
        myMap.put("4号","王师傅");
        myMap.put("5号","王师傅");
        myMap.put("6号","王师傅");
        myMap.put("7号","王师傅");
        myMap.put("8号","王师傅");
        myMap.put("9号","王师傅");
        myMap.put("10号","隔壁老王");
        myMap.put("11号","王师傅");
        myMap.put("12号","王师傅");
        myMap.put("13号","王师傅");
        myMap.put("14号","王师傅");
        myMap.put("15号","王师傅");
        myMap.put("16号","王师傅");
        myMap.put("17号","王师傅");
        myMap.put("18号","王师傅");
        myMap.put("19号","王师傅");
        myMap.put("20号","王师傅");
        myMap.put("21号","王师傅");
        myMap.put("22号","王师傅");
        myMap.put("23号","王师傅");
        myMap.put("24号","王师傅");
        myMap.put("25号","王师傅");
        myMap.put("26号","王师傅");
        myMap.put("27号","王师傅");
        myMap.put("28号","王师傅");
        myMap.put("29号","王师傅");
        myMap.put("30号","王师傅");
        myMap.put("31号","王师傅");
        myMap.put("32号","王师傅");

        System.out.println("10号：" + myMap.get("10号"));
    }
}
