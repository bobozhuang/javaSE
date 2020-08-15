package main.java.com.bobozhuang.iolearn.scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * description：     while可以一直读，for循环可以控制读几次
 *              用流的方式读是以回车为结束的一行
 * author Hubery
 * date 2020-08-02
 * version v0.0.1
 * since v0.0.1
 **/
public class ReadBuffer {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
       /* while((str = bf.readLine()) != null){
            System.out.println(str);
        }*/
        for (int a = 0 ; a < 2; a++){

            String s = bf.readLine();
            System.out.println(
                    s
            );
        }
    }
}
