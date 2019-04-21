package main.java.com.bobozhuang.basic.chap02Lambda;

import java.util.Comparator;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:    lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）
 *      在 Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量。
 * @date: 2019/4/21 23:45
 * @Package main.java.com.bobozhuang.basic.chap02Lambda
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class TesterC {

    public static void main(String[] args) {
        int num = 1;
        TesterB.Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);
        num = 5;
        //报错信息：Local variable num defined in an enclosing scope must be final or effectively
//        final

        String first = "";
        Comparator<String> comparator = (first, second) -> Integer.compare(first.length(), second.length());  //编译会出错
    }

}
