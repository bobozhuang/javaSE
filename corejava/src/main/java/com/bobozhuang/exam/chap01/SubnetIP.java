package main.java.com.bobozhuang.exam.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * description：     子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据
 *          子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。利用子网掩码可以判断
 *          两台主机是否中同一子网中。若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。
 *
 *          示例：
 * I P 地址　 192.168.0.1
 * 子网掩码　 255.255.255.0
 *
 * 转化为二进制进行运算：
 *
 * I P 地址　11010000.10101000.00000000.00000001
 * 子网掩码　11111111.11111111.11111111.00000000
 *
 * AND运算
 *  　　　　11000000.10101000.00000000.00000000
 *
 * 转化为十进制后为：
 *  　　　　192.168.0.0
 *
 *
 *
 * I P 地址　 192.168.0.254
 * 子网掩码　 255.255.255.0
 *
 *
 * 转化为二进制进行运算：
 *
 * I P 地址　11010000.10101000.00000000.11111110
 * 子网掩码　11111111.11111111.11111111.00000000
 *
 * AND运算
 * 　　　　　11000000.10101000.00000000.00000000
 *
 * 转化为十进制后为：
 * 　　　　　192.168.0.0
 *
 * 通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络。
 * author Hubery
 * date 2020-08-02
 * version v0.0.1
 * since v0.0.1
 **/
public class SubnetIP {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while((str=br.readLine())!=null){
            String[] IP = str.split("\\.");
            String[] zi1 = br.readLine().split("\\.");
            String[] zi2 = br.readLine().split("\\.");

            int flag = 0;
            for(int i=0; i<4; i++){
                int a = Integer.parseInt(IP[i]);
                int b = Integer.parseInt(zi1[i]);
                int c = Integer.parseInt(zi2[i]);
                if(a<0||a>255||b<0||b>255||c<0||c>255){
                    flag = 1;
                    break;
                }

                if((a&b)!=(a&c)){
                    flag = 2;
                    break;
                }
            }
            System.out.println(flag);
        }
    }

}
