package main.java.com.bobozhuang.exam;

import java.io.IOException;
import java.util.Scanner;

/**
 * description： 字符串倒序
 * author Hubery
 * date 2020-07-31
 * version v0.0.1
 * since v0.0.1
 **/
public class InvertedOrder {

    /*public static void main(String[] args) throws IOException {
        //这个答案都没有输入，怎么搞的，没明白呀
        int length = System.in.available();
        if(length > 2) {
            byte[] bts = new byte[length-1];
            int flag = System.in.read(bts);
            if(flag!= -1) {
                byte[] tmp = new byte[bts.length];
                for (int i = 0; i < tmp.length; i++) {
                    tmp[i] = bts[tmp.length - i - 1];
                }
                System.out.println(new String(tmp));
            }

        }
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();//next()是遇到空格；nextLine()是遇到回车
            StringBuilder sb = new StringBuilder(str);
            System.out.println(sb.reverse().toString());
        }
    }

}
