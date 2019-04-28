package main.java.com.bobozhuang.basic.chap02Lambda;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:    也可以直接在 lambda 表达式中访问外层的局部变量：
 * @date: 2019/4/21 23:43
 * @Package main.java.com.bobozhuang.basic.chap02Lambda
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class TesterB {
    public static void main(String args[]) {
        final int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);  // 输出结果为 3
    }
    //convert   使转变；转换
    public interface Converter<T1, T2> {
        void convert(int i);
    }
}
