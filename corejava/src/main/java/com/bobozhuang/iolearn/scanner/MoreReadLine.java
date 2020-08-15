package main.java.com.bobozhuang.iolearn.scanner;

import java.util.Scanner;

/**
 * description： 这里不需要在意for循环嵌套，重点关注可以通过for决定循环几次结束
 * author Hubery
 * date 2020-08-02
 * version v0.0.1
 * since v0.0.1
 **/
public class MoreReadLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
                System.out.println(ans);
            }
        }
        System.out.println(ans);
    }


}
