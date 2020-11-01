package main.java.com.bobozhuang.basic.chap07Optional;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @version V1.0
 * @author: Hubery
 * @Description: Optional 类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
 * Optional 是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
 * Optional 类的引入很好的解决空指针异常。
 * @date: 2019/4/28 21:11
 * @Package main.java.com.bobozhuang.basic.chap07Optional
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Tester {
    public static void main(String args[]) {

        Tester Tester = new Tester();
        Integer value1 = null;
        Integer value2 = new Integer(10);

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        try {
            Optional<Integer> a1 = Optional.of(value1);//真的抛出了异常
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Tester.sum(a, b));

        //ifPresent:如果Optional有值则调用consumer处理，否则不处理
        Optional<Object> o1 = Optional.ofNullable(null);
        o1.ifPresent(s -> System.out.println(s));

    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {

        // Optional.isPresent - 判断值是否存在

        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());
        //Optional.get - 获取值，值需要存在,没有抛出NoSuchElementException
        try{

        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        Integer value2 = b.get();
        Integer a3 = a.get();
        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));
        //  orElseGet：orElseGet与orElse方法类似，区别在于得到的默认值。orElse方法将传入的字符串作为默认值，
        // orElseGet方法可以接受Supplier接口的实现用来生成默认值
        Optional<Object> o1 = Optional.ofNullable(null);
        System.out.println(o1.orElseGet(() -> "default value")); // default value

        return value1 + value2;
    }

}
