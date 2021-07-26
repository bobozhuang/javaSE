package main.java.com.bobozhuang.stringDemo;

import java.math.BigInteger;
import java.util.Stack;

/**
 * description��Java ʵ���ַ�����ת
 * <p>
 * �ַ���������ͣ�1������ĸ   2��������   3����ĸ�������
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
        System.out.println(reverseStringBuilder("�õ�"));
        System.out.println(CharAtreverse("12345"));
    }

    /**
     * 1. ʹ���ֳɵ� reverse() ����
     */
    private static void testOne() {
        StringBuilder sb1 = new StringBuilder("Hello you");
        System.out.println(sb1.reverse()); //uoy olleH

        StringBuffer sb2 = new StringBuffer("haha go");
        System.out.println(sb2.reverse()); //og ahah
    }

    /**
     * 2. ���ַ���ת�����ַ����飬Ȼ���ĩβ��ʼ��ƴ���ַ���
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
     * 2. ���ַ���ת�����ַ����飬ѭ��һ�ξ͸�ǰ�󶼸�ֵ
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
     * 3������Ǵ����֣�����ͨ��ȡ��ͳ�ֱ�ӵ���
     * int �� Integer ����ʵ����Ч����һ���ģ��������������͵����ֵ����СֵҲһ����
     * ���ֵΪ: Integer.MAX_VALUE = 2147483647 = 2��32�� -1��
     * ��Сֵ��Integer.MIN_VALUE = 2147483647 = -2��32��
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
     * 4��
     */
    private static void testFour(String num) {
        BigInteger bigInteger = new BigInteger(num);
    }

    /**
     * 5��ʹ��ջ
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
     * 6���ݹ�
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
     * 7��ͨ��StringBuiler��reverse()�ķ��������ķ�ʽ��
     */
    public static String reverseStringBuilder(String s) {
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();
        return reverse;
    }

    /**
     * 8.ͨ��String���charAt()�ķ�������ȡ�ַ����е�ÿһ���ַ���Ȼ����ƴ��Ϊһ���µ��ַ�����
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
