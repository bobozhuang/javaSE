package main.java.com.bobozhuang.exam.chap01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * description：     计算等差数列的前N项和，这种要推到等差数列的公式
 * author Hubery
 * date 2020-08-02
 * version v0.0.1
 * since v0.0.1
 **/
public class ArithmeticProgression {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while((str=br.readLine())!=null){
            int n = Integer.parseInt(str);
            System.out.println((3*n*n+n)/2);
        }
    }

}
