package main.java.com.bobozhuang.stringDemo;

import java.io.UnsupportedEncodingException;

/**
 * description：
 * author Hubery
 * date 2020-03-24
 * version v0.0.1
 * since v0.0.1
 **/
public class StringByte {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String a = "1111 ";
        String b = "你";
        byte[] arr1;
        byte[] arr2;
        arr1 = a.getBytes();
        arr2 = b.getBytes("GBK");
        //字符串 “你”转换成字节之后 数组array里面有两个元素 ，一个 -60 ，一个 -29，这是因为，
        //字符“你”是一个中文字符，占用了两个字节，当将其转换为byte时高8位转换成一个字节显示为-60 ， 低8位转换成一个字节显示为 -29 。
        for (byte x :
                arr1) {
            System.out.println("x : " + x);
        }

        for (byte y :
                arr2) {
            System.out.printf("y : " + y);
        }
        //1的ASCLL码为49，空格是32 ，这里就可以发现，这个方法是先将字符串每八位（也就是一个字节）截取下来，存入byte数组里的，数字“1”也是用一个字节表示的 。
    }
}
