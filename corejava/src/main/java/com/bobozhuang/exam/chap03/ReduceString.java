package main.java.com.bobozhuang.exam.chap03;

/**
 * description：
 * author Hubery
 * date 2020-11-25
 * version v0.0.1
 * since v0.0.1
 **/
public class ReduceString {

    public static void main(String[] args) {
        String a = "1234567";
        String b = "123459";
        String c = "";
        int al = a.length();
        int bl = b.length();
        //判断长度，用长的 - 短的
        if (al - bl == 0) {
            for (int i = 0; i < a.length(); i++) {
                if ((Integer.parseInt(a.substring(i, i + 1)) - Integer.parseInt(b.substring(i, i + 1))) < 0) {
                    c = b;
                    a = b;
                    b = c;
                    continue;
                }
            }
        } else if (al < bl) {
            c = a;
            a = b;
            b = c;
        }
        //循环次数取最长的，结束循环的取最短
        c = "";
        for (int j = 0; j < a.length() - 1; j++) {
            int pa = a.length();
            int pb = b.length();
            int a1 = Integer.parseInt(a.substring(pa - 1 - j, pa - j));
            int b1 = Integer.parseInt(b.substring(pb - 1 - j, pb - j));
            //不需要借一位的时候
            if ((a1 - b1) >= 0) {
                c = c + String.valueOf(a1 - b1);
            }
            //需要借一位的时候
            if ((a1 - b1) < 0) {
                //获取到前一位
                int num = Integer.parseInt(a.substring(pa - 1 - 1 - j, pa - 1 - j));
                //前一位大于0
                if(num > 0){
                    //将前一位 - 1，替换到原来的位置
                }
                int result = num - 1;
                String end = a.substring(0, pa - 2) + String.valueOf(result) + "0" ;
                a = end;
                c = String.valueOf(b1 - a1);
            }

        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }

}
