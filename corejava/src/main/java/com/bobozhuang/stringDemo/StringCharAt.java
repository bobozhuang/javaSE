package main.java.com.bobozhuang.stringDemo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * description：
 * author Hubery
 * date 2020-05-21
 * version v0.0.1
 * since v0.0.1
 **/
public class StringCharAt {

    public static void main(String[] args) {

        try {
            enS3();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void enS() throws UnsupportedEncodingException {
        String name = URLEncoder.encode("山东", "UTF-8");
        System.out.println(name);
        name = URLEncoder.encode(name, "UTF-8");
        System.out.println(name);
        name = URLDecoder.decode(name, "UTF-8");
        System.out.println(name);
        System.out.println(URLDecoder.decode(name, "UTF-8"));
    }

    public static void enS2() throws UnsupportedEncodingException {

        String encoding = "UTF-8";
        String str = null;
        String str1 = null;
        StringBuilder strBuilder = new StringBuilder();
        str = URLEncoder.encode("山东", encoding);
        for (int i = 0; i < str.length(); i++) {
            strBuilder.append(str.charAt(i));
        }
        System.out.printf("山东GBK：" + strBuilder.toString());
        str1 = URLDecoder.decode(str, encoding);
        System.out.printf("山东GBK：" + str1);
    }

    public static void enS3() throws UnsupportedEncodingException {

        String a = "山东";
        byte[] bytes = a.getBytes("UTF-8");
        String gbk = new String(bytes, "GBK");
        gbk = URLEncoder.encode(gbk, "GBK");
        System.out.printf(gbk);
        gbk = URLDecoder.decode(gbk, "GBK");
        System.out.printf(gbk);
    }
}
