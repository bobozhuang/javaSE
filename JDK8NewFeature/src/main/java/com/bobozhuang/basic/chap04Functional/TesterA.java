package main.java.com.bobozhuang.basic.chap04Functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @version V1.0
 * @author: Hubery
 * @Description: Predicate<T>
 *  接受一个输入参数，返回一个布尔值结果。
 *  通过Predicate接口可以将 lambda 的 表达式传 给Predicate接口 的test方法，test通过表达式就可以带入参数返回 boolean值
 * @date: 2019/4/28 16:33
 * @Package main.java.com.bobozhuang.basic.chap04Functional
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class TesterA {
    public static void main(String args[]){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("输出所有数据:");
        // Predicate<Integer> predicate = n -> true
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // n 如果存在则 test 方法返回 true
        // 传递参数 n
        eval(list, n->true);

        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n%2 为 0 test 方法返回 true

        System.out.println("输出所有偶数:");
        eval(list, n-> n%2 == 0 );

        // Predicate<Integer> predicate2 = n -> n > 3
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n 大于 3 test 方法返回 true
        System.out.println("输出大于 3 的所有数字:");
        eval(list, n-> n > 3 );
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer A: list) {

            if(predicate.test(A)) {
                System.out.println(A + "???");
            }
        }
    }

    /**
     * list.stream().filter(n -> n > 3).forEach(System.out::println);
     * @param list
     * @param predicate
     */
    private static void evalA(List<Integer> list, Predicate<Integer> predicate) {
        list.stream().filter(predicate).forEach(System.out::println);
    }

}
