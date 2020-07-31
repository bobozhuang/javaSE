package main.java.com.bobozhuang.exam;

import java.util.Scanner;

/**
 * description：
 * author Hubery
 * date 2020-05-28
 * version v0.0.1
 * since v0.0.1
 **/
public class wordLength8P {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s=scanner.nextLine();
            split(s);
        }
    }

    public static void split(String s){
        while(s.length()>=8){
            System.out.println(s.substring(0, 8));
            s=s.substring(8);
        }
        if(s.length()<8&&s.length()>0){
            s=s+"00000000";
            System.out.println(s.substring(0, 8));
        }
    }

}
