package main.java.com.bobozhuang.basic.chap07Optional;

import java.util.Optional;

/**
 * description：     Optional 为空时，orElse和orElseGet 区别不大
 *              但当Optional有值时，orElse仍然会去调用方法创建对象，而orElseGet不会再调用方法；
 *              在我们处理的业务数据量大的时候，这两者的性能就有很大的差异。
 *
 * author Hubery
 * date 2020-10-02
 * version v0.0.1
 * since v0.0.1
 **/
public class Tester2 {

    public static void main(String[] args) {

        //orElseAndorElseGet();

        map();
    }

    /**
     * orElse 和 orElseGet 看似差不多，其实有很大不同
     *
     * 如何证明orElseGet没有创建对象，判断是否执行createNew方法
     */
    public static void orElseAndorElseGet() {
        Shop shop = null;
        System.out.println("test orElseGet");
        System.out.println(Optional.ofNullable(shop).orElseGet(() -> createNew()));
        System.out.println("test orElse");
        System.out.println(Optional.ofNullable(shop).orElse(createNew()));

        //System.out.println(Optional.ofNullable(shop1).orElseGet(Tester2::get));


        Shop shop2 = new Shop("长腿丝袜", 100);
        System.out.println("test orElse");
        System.out.println(shop2);
        System.out.println(Optional.ofNullable(shop2).orElse(createNew()));
        System.out.println("test orElseGet");
        System.out.println(Optional.ofNullable(shop2).orElseGet(() -> createNew()));
    }

    //createNew
    private static Shop createNew () {
        System.out.println("create new");
        return new Shop("丝袜", 50);
    }


    static class Shop {
        String productName;
        int num;

        public Shop(String productName, int num) {
            this.productName = productName;
            this.num = num;
        }

       /* @Override
        public String toString() {
            return "Shop{" +
                    "productName='" + productName + '\'' +
                    ", num=" + num +
                    '}';
        }*/
    }

    /**
     * orElseThrow：如果有值则将其返回，否则抛出supplier接口创建的异常。
     */
    public static void orElseThrow() {
        Optional<Object> o1 = Optional.ofNullable(null);
        try {
            o1.orElseThrow(() -> new Exception("异常！"));
        } catch (Exception e) {
            System.out.println("info:" + e.getMessage());
        }//输出：info:异常!
    }

    /**
     * map：如果有值，则对其执行调用mapping函数得到返回值。如果返回值不为null，则创建包含mapping返回值的
     * Optional作为map方法返回值，否则返回空Optional。
     *
     *  mapping就是方法里面的： e -> e.toUpperCase()
     */
    public static void map() {
        Optional<String> optional = Optional.of("xiaoming");
        String s = optional.map(e -> e.toUpperCase()).orElse("shiyilingfeng");
        System.out.println(s); //输出: XIAOMING

        //这个空的字符串不是空，如果时空结果为：shiyilingfeng
        Optional<String> optional2 = Optional.of("");
        String s2 = optional2.map(e -> e.toUpperCase()).orElse("shiyilingfeng");
        System.out.println(s2);
        //optional2.map(update -> inputStr("map"));//这个内部的方法必须有返回值，就是必须要用orElse判空
        Optional<String> optional3 = Optional.of("xiaoming");
        String s3 = optional3.map(update -> backNull("map")).orElse("shiyilingfeng");//这个内部的方法必须有返回值
        System.out.println(s3);
    }

    public static String inputStr(String str){
        //System.out.println(str);
        return str;
    }
    public static String backNull(String str){
        //System.out.println(str);
        return null;
    }
}
