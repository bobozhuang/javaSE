package main.java.com.bobozhuang.stringDemo;

import java.math.BigInteger;
import java.util.Stack;

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
        testTwoP("0123456789");
        testThree("123567890");
        System.out.println(strReverseWithRecursive("123567890"));
        System.out.println(reverseStringBuilder("好的"));
        System.out.println(CharAtreverse("12345"));
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
        String abc = "poiuytrewq";
        char[] cba = abc.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = charStr.length - 1; i >= 0; i--) {
            sb.append(charStr[i]);
        }
        System.out.println(sb);
    }

    /**
     * 2. 将字符串转换成字符数组，循环一次就给前后都负值
     */
    private static void testTwoP(String str) {
        char[] charStr = str.toCharArray();
        String abc = "poiuytrewq";
        int length = str.length();
        char[] cba = new char[length];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= length / 2; i++) {
            cba[length - 1 - i] = charStr[i];
            cba[i] = charStr[length - 1 - i];
        }
        System.out.println(new String(cba));
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
     * 4、
     */
    private static void testFour(String num) {
        BigInteger bigInteger = new BigInteger(num);
    }

    /**
     * 5。使用栈
     *
     * @param string
     * @return
     */
    public static String strReverseWithStack(String string) {
        if (string == null || string.length() == 0) return string;
        Stack<Character> stringStack = new Stack<>();
        char[] array = string.toCharArray();
        for (Character c : array) {
            stringStack.push(c);
        }
        int length = string.length();
        for (int i = 0; i < length; i++) {
            array[i] = stringStack.pop();
        }
        return new String(array);
    }

    /**
     * 6。递归
     */
    public static String strReverseWithRecursive(String string) {
        if (string == null || string.length() == 0) return string;
        int length = string.length();
        if (length == 1) {
            return string;
        } else {
            return strReverseWithRecursive(string.substring(1)) + string.charAt(0);
        }
    }

    /**
     * 7。通过StringBuiler的reverse()的方法，最快的方式。
     */
    public static String reverseStringBuilder(String s) {
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();
        return reverse;
    }

    /**
     * 8.通过String类的charAt()的方法来获取字符串中的每一个字符，然后将其拼接为一个新的字符串。
     *
     * @param s
     * @return
     */
    public static String CharAtreverse(String s) {

        int length = s.length();
        String reverse = "";
        for (int i = 0; i < length; i++)
            reverse = s.charAt(i) + reverse;
        return reverse;
    }

}
