package main.java.com.bobozhuang.basic.chap02Lambda;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:    变量作用域
 * lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误。
 * @date: 2019/4/21 23:42
 * @Package main.java.com.bobozhuang.basic.chap02Lambda
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class TesterA {
    final static String salutation = "Hello! ";

    public static void main(String args[]){
        GreetingService greetService1 = message ->
                System.out.println(salutation + message);
        greetService1.sayMessage("Hubery");
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}
