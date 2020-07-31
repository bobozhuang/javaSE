package main.java.com.bobozhuang.exam;

import java.util.Scanner;

/**
 * description：计算字符串最后一个单词的长度，单词以空格隔开。
 *                  总的长度 - 最后空格位置的长度
 * author Hubery
 * date 2020-05-27
 * version v0.0.1
 * since v0.0.1
 **/
public class WordLength {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s="";
        while(input.hasNextLine()){
            s=input.nextLine();
            System.out.println("s : " + s);
            System.out.println(s.length()-1-s.lastIndexOf(" "));
        }
    }

}
