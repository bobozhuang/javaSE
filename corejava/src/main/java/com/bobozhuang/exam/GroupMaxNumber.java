package main.java.com.bobozhuang.exam;

import java.util.*;

/**
 * description：组最大数字,比如输入123，546，8，32，输出854632123
 * author Hubery
 * date 2020-07-28
 * version v0.0.1
 * since v0.0.1
 **/
public class GroupMaxNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map treeMap = new TreeMap(
                new Comparator() {
                    @Override
                    public int compare
                            (Object o1, Object o2) {
                        Integer i1 = Integer.valueOf((String) o1);
                        Integer i2 = Integer.valueOf((String) o2);
                        return i2-i1;
                    }
                }
        );

        if (sc.hasNext()) {
            String str = sc.nextLine();
            String[] split = str.split("，");
            for (String num :
                    split) {
                if (!num.equals("")){
                    treeMap.put(num.substring(0,1),num);
                }
            }
        }
        Iterator<Map.Entry<Integer, Integer>> it = treeMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            System.out.print(entry.getValue());
        }
        System.out.println();
    }

}
