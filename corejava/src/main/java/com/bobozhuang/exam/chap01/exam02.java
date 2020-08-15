package main.java.com.bobozhuang.exam.chap01;

import java.util.Scanner;

/**
 * description：
 * author Hubery
 * date 2020-05-27
 * version v0.0.1
 * since v0.0.1
 **/
public class exam02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean b = true;
        while(b){
            String next = scanner.next();

            System.out.println("-- : " + next);
            b = scanner.hasNext();
            System.out.println("b- : " + b);
        }

    }

}
