package main.java.com.bobozhuang.util.tool;

import java.util.Calendar;

/**
 * description：
 * author Hubery
 * date 2020-04-15
 * version v0.0.1
 * since v0.0.1
 **/
public class Test {

    public static void main(String[] args) {

        String localAddress = Util.getLocalAddresses()[0];
        System.out.println(localAddress);

        long l = System.currentTimeMillis();
        Calendar calendar = Util.bocmDatetimeToCal(String.valueOf(l));
        Calendar calendar1 = Util.bocmDateToCal(String.valueOf(l));
        System.out.println(calendar);
        System.out.println(calendar1);
    }

}
