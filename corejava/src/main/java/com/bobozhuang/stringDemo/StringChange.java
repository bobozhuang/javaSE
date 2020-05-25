package main.java.com.bobozhuang.stringDemo;

/**
 * description：
 * author Hubery
 * date 2020-04-26
 * version v0.0.1
 * since v0.0.1
 **/
public class StringChange {

    public static void main(String[] args) {
        String ver = "44.0";
        String ver2 = "44.0123";

        Double aDouble = Double.valueOf(ver);
        System.out.println(aDouble);


        double num1 = 0.0;

        String qq = "19.987";

        num1 = Double.valueOf(qq.toString());
        System.out.println(num1);
    }


}
