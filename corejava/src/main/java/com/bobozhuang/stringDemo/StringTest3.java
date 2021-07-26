package main.java.com.bobozhuang.stringDemo;

/**
 * description：
 * author Hubery
 * date 2020-11-17
 * version v0.0.1
 * since v0.0.1
 **/
public class StringTest3 {
    public static void main(String[] args) {

        String str1 = "133";
        String str2 = new String("133");
        System.out.println(str1.equals(str2));
        System.out.println(str1==str2);

        String str3 = new String("abc");
        String str4 = new String("abc");
        System.out.println(str3 == "abc");
        System.out.println(str3.equals("abc"));


    }
}
