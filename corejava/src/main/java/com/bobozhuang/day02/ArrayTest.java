package main.java.com.bobozhuang.day02;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] i = new int[10];
        i[0] = 10;
        i[1] = 20;
        i[2] = 30;
        System.out.println(i.length);
        //遍历数组
        for (int j = 0; j < i.length; j++) {
            System.out.print(i[j] + " ");
        }
        System.out.println();
        System.out.println
                (Arrays.toString(i));
        //增强for
        //只能用于遍历数组或者集合
        System.out.println("------");
        for (int m : i) {
            System.out.print(m + " ");
        }
        System.out.println("------");

        String str = "/ebank/spdb/devops";
        String[] split = str.split("/");
        for (int j = 0; j < split.length; j++) {
            System.out.println(split[j]);
        }

        System.out.println("------");

        String[] strings = new String[]{"qw","e"};
        strings[0]=null;
        System.out.println(strings[0]);

        String[] strrr =null;


        System.out.println(strrr.length);

    }

}
