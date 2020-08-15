package main.java.com.bobozhuang.exam.chap01;

import java.util.Scanner;

/**
 * description： java ASCII码值
 *              第33～126号(共94个)是字符，
 *              其中第48～57号为0～9十个阿拉伯数字；
 *              65～90号为26个大写英文字母，
 *              97～122号为26个小写英文字母，
 *              其余为一些标点符号、运算符号等。
 * author Hubery
 * date 2020-08-02
 * version v0.0.1
 * since v0.0.1
 **/
public class TestASCII01 {


    public static void main(String[] args) {
        //在键盘上输入任意一个字母 ，显示ASCII码值
//        Scanner in = new Scanner(System.in);
//        String b = in.next();
//        for (int i = 0; i < b.length(); i++) {
//            System.out.println(b.charAt(i) + " " + (byte) b.charAt(i));
//        }

        outAscii();
    }

    /**
     * 输出所有字符及其对应的ASCII码值
     */
    public static void outAscii() {
        for (int i = 0; i < 255; i++) {
            char a = (char) i;
            System.out.println(a + " : " + i);
        }
    }
}
