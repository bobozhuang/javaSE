package main.java.com.bobozhuang.stringDemo;

import java.io.UnsupportedEncodingException;

/**
 * description：Jvm 内存中 String 的表示是采用 unicode 编码
 * UTF-8 是 Unicode 的实现方式之一
 * author Hubery
 * date 2020-03-23
 * version v0.0.1
 * since v0.0.1
 **/
public class StringEncoding {

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] b_gbk = "中".getBytes("GBK");
        byte[] b_utf8 = "中".getBytes("UTF-8");
        byte[] b_iso88591 = "中".getBytes("ISO8859-1");
        byte[] b_unicode = "中".getBytes("unicode");

        System.out.println("GBK length: " + b_gbk.length);
        System.out.println("UTF-8 length: " + b_utf8.length);
        System.out.println("ISO8859 length: " + b_iso88591.length);
        System.out.println("unicode length: " + b_unicode.length);

        String s_gbk = new String(b_gbk,"GBK");
        String s_utf8 = new String(b_utf8,"UTF-8");
        String s_iso88591 = new String(b_iso88591,"ISO8859-1");
        String s_unicode = new String(b_unicode, "unicode");


        String z_iso88591 = new String("中".getBytes("UTF-8"),"ISO8859-1");
        String z_utf8 = new String(z_iso88591.getBytes("ISO8859-1"),"UTF-8");

        String s = "浣犲ソ"; //这是"你好"的gbk编码的字符串
        String ss = new String(s.getBytes("GBK"), "UTF-8");
        System.out.println(ss);


        String sa = "安徽省"; //这是"你好"的gbk编码的字符串
        String ssa = new String(sa.getBytes("UTF-8"), "GBK");
        System.out.println(ssa);


    }
}
