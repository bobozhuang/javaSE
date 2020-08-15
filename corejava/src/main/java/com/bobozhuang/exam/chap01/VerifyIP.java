package main.java.com.bobozhuang.exam.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * description： 返回判断的结果YES or NO
 * author Hubery
 * date 2020-08-02
 * version v0.0.1
 * since v0.0.1
 **/
public class VerifyIP {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while((str = bf.readLine()) != null){

            String[] subIP = str.split("\\.");

            for(int i =0; i < subIP.length; i++){
                Integer intIP = Integer.valueOf(subIP[i]);
                if(intIP >= 0 && intIP<=255){
                    if(i == subIP.length-1){
                        System.out.println("YES");
                    }
                    continue;
                } else{
                    System.out.println("NO");
                    break;
                }
            }
            System.out.println("please input IP : ");
        }
    }

}
