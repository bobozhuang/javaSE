package main.java.com.bobozhuang.stringDemo;

/**
 * description： 测试汉字的长度
 * author Hubery
 * date 2020-10-28
 * version v0.0.1
 * since v0.0.1
 **/
public class StringTest2 {

    public static void main(String[] args) {
        //测试汉字的长度
        String str = "旭日";
        System.out.println(str.length());
        //测试substring截取下标越界
        String str2 = "1231231231231";
        str2 = "";
        System.out.println(str2.substring(3, 33));
        //格式化方法
        int str1 = 1123;
        String format = String.format("%05d", str1);//不够5位前面补0
        System.out.println(format);
    }
}
