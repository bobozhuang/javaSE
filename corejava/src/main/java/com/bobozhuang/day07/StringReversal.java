package main.java.com.bobozhuang.day07;

import java.math.BigInteger;

/**
 * description：Java 实现字符串反转
 * <p>
 * 字符串组合类型：1、纯字母   2、纯数字   3、字母数字组合
 * <p>
 * author Hubery
 * date 2019-11-07
 * version v0.0.1
 * since v0.0.1
 **/
public class StringReversal {

    public static void main(String[] args) {

        testOne();
        String str = "abcde";
        testTwo("123456789");
        testThree("1235678900");
    }

    /**
     * 1. 使用现成的 reverse() 方法
     */
    private static void testOne() {
        StringBuilder sb1 = new StringBuilder("Hello you");
        System.out.println(sb1.reverse()); //uoy olleH

        StringBuffer sb2 = new StringBuffer("haha go");
        System.out.println(sb2.reverse()); //og ahah
    }

    /**
     * 2. 将字符串转换成字符数组，然后从末尾开始，拼接字符串
     */
    private static void testTwo(String str) {
        char[] charStr = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = charStr.length - 1; i >= 0; i--) {
            sb.append(charStr[i]);
        }
        System.out.println(sb);
    }

    /**
     * 3、如果是纯数字，可以通过取余和除直接倒置
     * int 和 Integer 类型实际上效果上一样的，包括这两种类型的最大值和最小值也一样，
     * 最大值为: Integer.MAX_VALUE = 2147483647 = 2的32次 -1，
     * 最小值：Integer.MIN_VALUE = 2147483647 = -2的32次
     */
    private static void testThree(String num) {
        //valueNum % 10
        Integer valueNum = Integer.valueOf(num);
        int postfix = num.length() - (valueNum % 10);
        System.out.println(postfix);
        int res = 0;
        while (valueNum > 0) {
            res = res * 10 + valueNum % 10;
            valueNum /= 10;
        }

        System.out.println(res);
    }

    /**
     *
     */
    private static void testFour(String num) {
        BigInteger bigInteger = new BigInteger(num);
    }
}
