package main.java.com.bobozhuang.exam.chap02;

import java.io.IOException;
import java.io.InputStream;

/**
 * description：
 * author Hubery
 * date 2020-08-08
 * version v0.0.1
 * since v0.0.1
 **/
public class JiaFa {

    public static void main(String[] args) {

        new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };

        int a;
        a = 13 & 17;

        double   b = -5 + 1/4 + 2*-3 + 5.0;
        double c = 1/4;
        System.out.println(c);

        int i = 0;
        i = i++ + i;
        System.out.println("I =" +i);

        String s1 = "xiaopeng" ;
        String s2 = "xiaopeng" ;
        String s3 =new String (s1);

        System.out.println(s1 == s2);
        System.out.println(s3 == s2);
        System.out.println(s1 == s3);


    }

}