package main.java.com.bobozhuang.exam;

import java.util.Scanner;

/**
 * description：求输入A和B的最小公倍数。
 * 输入描述:
 * 输入两个正整数A和B。
 * <p>
 * 链接：https://www.nowcoder.com/questionTerminal/22948c2cad484e0291350abad86136c3?answerType=1&f=discussion
 * 来源：牛客网
 * <p>
 * 求最大公约数有两种方法 更相减损法和辗转相处法 最小公倍数在求出最大公约数后 两个数相乘除以最大公约数就是最小公倍数
 * 以下我们用的是更相减损法
 * 更相减损法是拿两个数中的较大值减去较小值，然后在减数、被减数、差之间选取两个较小值继续相减，直到减数和被减数相等，得出的数就是最大公约数。
 * 例：//更相减损术：
 * //8 10
 * //10 - 8=2
 * //8 - 2= 6
 * //6-2=4
 * //4-2=2
 * //2==2于是最大公约数就是2
 * <p>
 * author Hubery
 * date 2020-07-30
 * version v0.0.1
 * since v0.0.1
 **/
public class CommonMultiple {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int int1 = scanner.nextInt();
        int int2 = scanner.nextInt();
        System.out.println(int1 * int2 / methods(int1, int2));
    }

    public static int methods(int int1, int int2) {
        if (int1 == int2) {
            return int2;
        }
        if (int1 > int2) {
            int differ = int1 - int2;
            return methods(int2, differ);
        } else {
            int differ = int2 - int1;
            return methods(int1, differ);
        }
    }


    private static void method2(int n1, int n2) {
        int n3 = gcd(n1, n2);
        System.out.println(n1 * n2 / n3);
    }

    private static int gcd(int n1, int n2) {
        if (n2 == 0) return n1;
        return gcd(n2, n1 % n2);
    }

}
