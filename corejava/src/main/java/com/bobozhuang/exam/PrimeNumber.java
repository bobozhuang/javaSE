package main.java.com.bobozhuang.exam;

import java.util.Scanner;

/**
 * description：输入一个正整数(long型整数)，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 *              最后一个数后面也要有空格
 *          输入：180   输出：2 2 3 3 5
 * author Hubery
 * date 2020-05-28
 * version v0.0.1
 * since v0.0.1
 **/
public class PrimeNumber {

        public static void main(String [] args)
        {
            Scanner sc=new Scanner(System.in);
            long params=sc.nextLong();
            if(params<2)
            {
                sc.close();
                return ;
            }
            String result =getResult(params);
            System.out.println(result);
            sc.close();

        }

        public static String getResult(long ulDataInput)
        {
            StringBuilder str=new StringBuilder();
            int index=2;
            while(index<=ulDataInput)
            {
                if(ulDataInput%index==0){
                    if(index==ulDataInput){
                        str.append(index).append(" ");
                        break;
                    }else{
                        str.append(index).append(" ");
                        ulDataInput=ulDataInput/index;
                    }
                }else
                {
                    index++;
                }
            }
            return str.toString();
        }
}
