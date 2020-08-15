package main.java.com.bobozhuang.exam;

import java.util.Scanner;

/**
 * description：计算一个数字的立方根，不使用库函数
 * author Hubery
 * date 2020-07-31
 * version v0.0.1
 * since v0.0.1
 **/
public class CubeRoot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        getCubeRoot(a);
    }

    public static void getCubeRoot(double num) {

        double x = 1.0;
        for (; Math.abs(Math.pow(x, 3) - num) > 1e-3; x = x - ((Math.pow(x, 3) - num) / (3 * Math.pow(x, 2)))) ;
        System.out.println(String.format("%.1f", x));

    }
}
