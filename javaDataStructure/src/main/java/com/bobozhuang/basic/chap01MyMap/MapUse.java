package main.java.com.bobozhuang.basic.chap01MyMap;


import java.util.*;
import java.util.HashMap;

public class MapUse {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("K1","V2");
        hashMap.put("K11","V22");
        hashMap.put("K111","V222");
        hashMap.put("K1111","V2222");
        hashMap.put("K11111","V22222");
        hashMap.put("K111111","V222222");
        hashMap.put("K1111111","V2222222");
        hashMap.put("K11111111","V22222222");
        hashMap.put("K111111111","V222222222");
        hashMap.put("1","一");
        hashMap.put("2","二");
        hashMap.put("3","三");
        hashMap.put("4","四");
        hashMap.put("5","五");
        hashMap.put("6","六");
        hashMap.put("7","七");
        hashMap.put("8","八");
        hashMap.put("9","九");
        hashMap.put("10","十");
        hashMap.put("11","十一");
        hashMap.put("12","十二");
        hashMap.put("13","十三");
        hashMap.put("14","十四");
        hashMap.put("15","十五");
        hashMap.put("16","十六");
        hashMap.put("17","十七");
        hashMap.put("18","十八");
        hashMap.put("19","十九");
        hashMap.put("20","二十");
        hashMap.put("21","二一");
        hashMap.put("22","二二");
        hashMap.put("23","二三");
        hashMap.put("24","二四");

        traverseA(hashMap);


    }
    public static void traverseA(HashMap hashMap){
        Set<String> set = hashMap.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            String value = (String) hashMap.get(key);
            System.out.println(key + "\t" + value);
        }
    }

    /**
     *
     * @param hashMap
     */
    public static void traverseB(HashMap hashMap){
        Set entries = hashMap.entrySet();
        Iterator iterator = entries.iterator();
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            String value = (String) hashMap.get(key);
            System.out.println(key + "\t" + value);
        }
    }
    public static void traverseC(HashMap<String,String> hashMap){
        for (Map.Entry entry :
                hashMap.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
    public static void traverseD(HashMap<String,String> hashMap){
        for (String v :
                hashMap.values()) {
            System.out.println(v);
        }
    }
}
