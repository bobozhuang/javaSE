package main.java.com.bobozhuang.exam.chap03;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * description：输入一串数字，放入栈中，入栈规则，每次一个数入栈，判断之前栈中数字之和与当前数字是否相等，如果相等这些数字出栈
 * 当前数字*2入栈，下一个数字继续按照这个 规则。
 * 1 2 5 7 9 1 2 2 5
 * 4 1 9 14 1
 *
 * 1 2 3 6
 * 12
 * author Hubery
 * date 2020-08-15
 * version v0.0.1
 * since v0.0.1
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        ArrayList<Long> longs = new ArrayList<>();
        for (int i = 0;i < s1.length; i ++){
            Long aLong = Long.parseLong(s1[i]);
            int flag = longs.size();
            longs = pp(aLong, longs);
            if (longs.size() != flag){
                pp(aLong*2,longs);
                longs.add(aLong * 2);

            }else {
                longs.add(aLong);
            }

        }
        longs.size();
        String str = "";
        for (int m = longs.size()-1; m >= 0 ; m --){
            str = str + longs.get(m) + " ";

        }
        System.out.println(str.trim());
    }

    public static ArrayList<Long> pp(Long l,ArrayList<Long> list){
        ArrayList<Long> a = new ArrayList<>();
        Long b = 0l;
        for (int i = list.size() - 1; i >= 0 ; i--){
            b = b + list.get(i);
            if (l == b){
                for (int j = 0;j<i;j++){
                    Long aLong = list.get(j);
                    a.add(aLong);
                }
                return a;
            }
        }
        return list;
    }
}
