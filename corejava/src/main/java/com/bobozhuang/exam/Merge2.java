package main.java.com.bobozhuang.exam;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * description：
 * author Hubery
 * date 2020-05-28
 * version v0.0.1
 * since v0.0.1
 **/
public class Merge2 {

    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        SortedMap<Integer,Integer> map = new TreeMap<>();
        int n = Integer.parseInt(str.nextLine());
        for (int i = 0;i<n;i++){
            String[] mid = str.nextLine().split("\\s+");
            addPare(map,mid);
        }
        System.out.println(mapToString(map));
    }

    private static String mapToString(SortedMap<Integer, Integer> map) {
        // TODO Auto-generated method stub
        StringBuilder builder = new StringBuilder();
        for(SortedMap.Entry<Integer,Integer>e:map.entrySet()){
            builder.append(e.getKey()).append(" ").append(e.getValue()).append("\r");
        }
        return builder.toString();
    }

    private static void addPare(SortedMap<Integer, Integer> map, String[] mid) {
        // TODO Auto-generated method stub
        int key = Integer.parseInt(mid[0]);
        int value = Integer.parseInt(mid[1]);
        if(map.containsKey(key)){
            map.put(key, map.get(key) + value);
        }else{
            map.put(key, value);
        }
    }

}
