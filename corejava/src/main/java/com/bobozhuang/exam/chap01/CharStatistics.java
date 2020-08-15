package main.java.com.bobozhuang.exam.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * description：字符统计 对字符中的各个英文字符（大小写分开统计），数字，空格进行统计，并按照统计个数由多到少输出,
 * 如果统计的个数相同，则按照ASII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
 * author Hubery
 * date 2020-08-02
 * version v0.0.1
 * since v0.0.1
 **/
public class CharStatistics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            char[] chArr = str.toCharArray();
            int[] temp = new int[150];
            for (int i = 0; i < chArr.length; i++) {
                temp[chArr[i]]++;
            }
            int max = 0;
            for (int j = 0; j < temp.length; j++) {
                if (max < temp[j]) {
                    max = temp[j];
                }
            }
            StringBuilder sbf = new StringBuilder();
            while (max != 0) {
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j] == max) {
                        sbf.append((char) j);
                    }
                }
                max--;
            }
            System.out.println(sbf.toString());
        }
    }
}
