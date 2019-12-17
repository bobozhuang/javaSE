package main.java.com.bobozhuang.day01;

public class TypeTest {
    public static void main(String[] args) {
        //整型
        byte b = 10;
        byte b1 = 12;
        short s = 100;
        int i = 999999;
        long l = 9999999999999L;

        int num = b;

        byte num1 = (byte) s;

//		byte num2 = b + 10;
        //浮点型
        float f = 3.1415926f;
        double pi = 3.1415926;
        //字符类型
        //char c = '杰';
        char c1 = 97;
        char c2 = 0x0061;
        char c3 = '\u59b9';

        System.out.println
                ("c1: " + c1 +
                        " c2: " + c2 +
                        " c3: " + c3);
        //布尔
        boolean flag = true;
        boolean flag1 = false;


        byte sum = (byte) (b + b1);

    }
}
