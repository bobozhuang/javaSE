package main.java.com.bobozhuang.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * description： 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * author Hubery
 * date 2020-05-27
 * version v0.0.1
 * since v0.0.1
 **/
public class wordLength8 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            String s = sc.nextLine();

            ArrayList<Object> al = new ArrayList<>();
            if (s.length() > 0) {
                addL(s, al);
                for (int i = 0; i < al.size(); i++) {
                    System.out.println(al.get(i));
                }
            }
        }

    }

    private static void addL(String scan, ArrayList arrayList) {

        if (scan.length() > 8) {

            String s1 = scan.substring(0, 8);
            arrayList.add(s1);
            String s2 = scan.substring(8);
            addL(s2, arrayList);
        } else {
            int l1 = scan.length();
            for (int i = 0; i < 8 - l1; i++) {

                scan = scan + "0";

            }
            arrayList.add(scan);
        }
    }
}
