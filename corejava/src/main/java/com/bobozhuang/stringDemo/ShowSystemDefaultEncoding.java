package main.java.com.bobozhuang.stringDemo;

/**
 * description：
 * author Hubery
 * date 2020-03-23
 * version v0.0.1
 * since v0.0.1
 **/
public class ShowSystemDefaultEncoding {
    public static void main(String[] args) {
        String encoding = System.getProperty("file.encoding");
        System.out.println(encoding);
    }
}