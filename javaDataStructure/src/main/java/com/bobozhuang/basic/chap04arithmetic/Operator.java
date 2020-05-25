package main.java.com.bobozhuang.basic.chap04arithmetic;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:
 * 算术运算符:       + - * / % ++ --
 * 关系运算符:       == != < > >= <=
 * 位运算符:         & | ~ ^ << >> >>>
 * 逻辑运算符:       && || !
 * 赋值运算符:       = += -+ *= /= (%)= <<= >>= &= ^= |=
 * 其他运算符:       条件运算符 ?:    也被称为三元运算符 b = (a == 1) ? 20 : 30;
 *                   instanceof 运算符     用于操作对象实例，检查该对象是否是一个特定类型（类类型或接口类型）。
 * @date: 2019/4/21 13:34
 * @Package main.java.com.bobozhuang.basic.chap04arithmetic
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Operator {
    public static void main(String[] args) {
        delivery();
    }
    public static void anOperator(){
        int a = 60;      /* 60 = 0011 1100 */
        int b = 13;      /* 13 = 0000 1101 */
        int c = 0;
        c = a & b;       /* 12 = 0000 1100 */
        System.out.println("a & b = " + c );

        c = a | b;       /* 61 = 0011 1101 */
        System.out.println("a | b = " + c );

        c = a ^ b;       /* 49 = 0011 0001 如果相对应位值相同，则结果为0，否则为1 */
        System.out.println("a ^ b = " + c );

        c = ~a;          /*-61 = 1100 0011 按位取反运算符翻转操作数的每一位，即0变成1，1变成0。 */
        System.out.println("~a = " + c );

        c = a << 2;     /* 240 = 1111 0000      11 1100 ->  1111 0000 */
        System.out.println("a << 2 = " + c );

        c = a >> 2;     /* 15 = 1111 */
        System.out.println("a >> 2  = " + c );

        c = a >>> 2;     /* 15 = 0000 1111    按位右移补零操作符，之前空位用0补齐  */
        System.out.println("a >>> 2 = " + c );
    }
    // 本质:a % b = a - a /b * b;
    public static void delivery(){
        double a = 10.2;
        double b = a%3;  //10.2-(10.2)/3*3 ==>10.2-概数(接近3.0的小数)*3 ==>10.2-概数(接近9.0的小数) ==>接近1.2的小数
        System.out.println("b:" + b);
    }

    /**
     * 取模运算实现算法
     * @param dividend
     * @param dividor
     * @return
     */
    public static double ramainder(double dividend, double dividor) {
        return dividend - dividend / dividor * dividor;
    }
}
