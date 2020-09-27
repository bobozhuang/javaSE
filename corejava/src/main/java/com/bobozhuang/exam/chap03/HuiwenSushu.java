package main.java.com.bobozhuang.exam.chap03;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * description：
 * author Hubery
 * date 2020-08-15
 * version v0.0.1
 * since v0.0.1
 **/
public class HuiwenSushu {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double h = scanner.nextDouble();

        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 1; i < h; i++) {
            boolean temp = false;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    temp = true;
                }
            }
            if (i == 1) {
                temp = true;
            }
            if (!temp) {
                al.add(i);
            }
        }
        int count = 0;
         String str = "";
        for (int i = 0; i < al.size(); i++) {
            if (isHws(al.get(i))) {
                str = str + "," + al.get(i);
                count++;
            }

        }
        System.out.println(count + "" + str);


    }

    public static boolean isHws(int num) {
        if (num < 10) {

            return true;
        }
        int temp = num;
        StringBuilder sb = new StringBuilder();
        while (temp > 0) {
            sb.append(temp % 10);
            temp = temp / 10;
        }
        if (Integer.parseInt(sb.toString()) == num) {

            return true;
        }

        return false;
    }
}
