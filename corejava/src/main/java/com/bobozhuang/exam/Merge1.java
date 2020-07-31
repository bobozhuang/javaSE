package main.java.com.bobozhuang.exam;

import java.util.*;

/**
 * description：数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，
 * 输出按照key值升序进行输出。
 * author Hubery
 * date 2020-05-28
 * version v0.0.1
 * since v0.0.1
 **/
public class Merge1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            TreeMap<Object, Object> hashMap = new TreeMap();
            String s = scanner.nextLine();
            for (int i = 0; i < Integer.valueOf(s); i++) {
                String s1 = scanner.nextLine();
                String[] s2 = s1.split(" ");

                String o = (String) hashMap.get(s2[0]);
                if (null != o) {
                    hashMap.put(s2[0], Integer.valueOf(o) + Integer.valueOf(s2[1]));
                } else {
                    hashMap.put(s2[0], s2[1]);
                }
            }

            for (Map.Entry entry :
                    hashMap.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }


        }
    }

}
