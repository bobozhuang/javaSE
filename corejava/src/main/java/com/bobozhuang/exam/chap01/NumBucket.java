package main.java.com.bobozhuang.exam.chap01;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * description：连续输入字符串(输出次数为N,字符串长度小于100)，请按长度为8拆分每个字符串后输出到新的字符串数组，
 *      长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入：2
 * abc
 * 12345789
 *
 * 输出：abc00000
 * 12345678
 * 90000000
 *
 *      自测没问题的，但是牛客就是不能通过，我的思路是每次够八个就放入list，然后不够的补0，补够8个后
 * author Hubery
 * date 2020-08-01
 * version v0.0.1
 * since v0.0.1
 **/
public class NumBucket {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int a = 0;
        int i = 0;
        while (scanner.hasNext()) {
            if (a == 0) {
                i = scanner.nextInt();
                a++;
            } else if (a <= i) {
                String num = scanner.next();
                addStr(num, list);
                a++;
            }
            if (a > i) {
                for (String s :
                        list) {
                    System.out.println(s);
                }
                break;
            }

        }
    }

    public static void addStr(String str, List list) {
        if (str.length() > 8) {
            String substring = str.substring(0, 8);
            list.add(substring);
            String substring1 = str.substring(8);
            if (substring1.length() > 8) {
                addStr(substring1, list);
            } else {
                String oo = "";
                for (int a = 0; a < 8 - substring1.length(); a++) {
                    oo = oo + "0";
                }
                list.add(substring1 + oo);
            }
        } else {
            String oo = "";
            for (int a = 0; a < 8 - str.length(); a++) {
                oo = oo + "0";
            }
            list.add(str + oo);
        }

    }
}
