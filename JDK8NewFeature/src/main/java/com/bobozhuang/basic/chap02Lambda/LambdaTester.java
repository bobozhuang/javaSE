package main.java.com.bobozhuang.basic.chap02Lambda;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:
 * @date: 2019/4/21 23:34
 * @Package main.java.com.bobozhuang.basic.chap02Lambda
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class LambdaTester {

    public static void main(String args[]){
        LambdaTester tester = new LambdaTester();
        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;
        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;
        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };
        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));
        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);
        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

}
