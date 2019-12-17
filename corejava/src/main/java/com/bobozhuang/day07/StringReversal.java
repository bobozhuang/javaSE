package main.java.com.bobozhuang.day07;

import java.math.BigInteger;

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
        testThree("1235678900");
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

        StringBuilder sb = new StringBuilder();
        for (int i = charStr.length - 1; i >= 0; i--) {
            sb.append(charStr[i]);
        }
        System.out.println(sb);
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
     *
     */
    private static void testFour(String num) {
        BigInteger bigInteger = new BigInteger(num);
    }
}
