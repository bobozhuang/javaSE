package main.java.com.bobozhuang.exam;

import java.util.*;

/**
 * description：
 * author Hubery
 * date 2020-05-16
 * version v0.0.1
 * since v0.0.1
 **/
public class Test1 {

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        String[] a = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] b = {"H", "S", "C", "D"};
        int startflag = 0;
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int key = in.nextInt();
            String value = in.next();

            hashMap.put(key, value);

            if (hashMap.size() > 2) {
                in.close();
                break;
            }
        }

        int f = 0;
        f = ths( a , b ,hashMap);
        if (f > 0) {
            System.out.println(f);
        }

    }

    /**
     * 同花顺
     *
     * @param hashMap
     * @return
     */
    public static int ths(String[] a, String[] b, HashMap<Integer, String> hashMap) {
        String flag = "a";//(String) hashMap.values();

        for (String v :
                hashMap.values()) {
            flag = v;
            if (flag.equals("a")) {
                break;
            }
        }
        for (String v :
                hashMap.values()) {

            if (!flag.equals(v)) {
                return 0;
            }
        }

        for (int i = 0; i < b.length; i++) {
            String s = b[i];
            if (flag.equals(s)) {
                flag = "a";
                break;
            }
        }
        if (!flag.equals("a")) {
            return 0;
        }

        String[] num = new String[5];
        int i = 0;
        Set entries = hashMap.entrySet();
        Iterator iterator = entries.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            num[0] = key;
            i++;
        }
        String[] num2 = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        for (int k = 0; k < num.length; k++) {
            for (int j = 0; j < a.length; j++) {
                if (num[k].equals(a[j])) {
                    num[j] = "1";
                }
            }
        }
        int p = 0;
        for (int j = 0; j < num2.length; j++) {
            if (num2.equals("1")) {
                p = j;
                break;
            }
        }
        int q = 0;
        for (int j = num2.length; j > 0; j--) {
            if (num2.equals("1")) {
                q = j;
                break;
            }
        }
        if (!((q - p) == 5)) {
            return 0;
        }
        return 1;
    }

}
