package main.java.com.bobozhuang.basic.arithmetic;

/**
 * description：重点：在代码review的时候，会尽力避免这种模糊不清的代码书写方式，这也是我们治理的重点。
 * author Hubery
 * date 2020-04-21
 * version v0.0.1
 * since v0.0.1
 **/
public class ValueOperat {

    public static void main(String[] args) {
        int a = 2;
        int b = a++ << ++a + ++a;
        System.out.println(b);
        //重点是 运算符的优先级
    }
}
