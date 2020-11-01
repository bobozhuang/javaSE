package main.java.com.bobozhuang.basic.chap06Stream;

import java.util.stream.Stream;

/**
 * description： Stream：
 *          of(T... values) 返回其元素是指定值的顺序排序流。
 *
 *
 * author Hubery
 * date 2020-10-03
 * version v0.0.1
 * since v0.0.1
 **/
public class StreamTest1 {
    public static void main(String[] args) {
        //map操作将原来的单词 转换成了每个单词的长度，利用了String自身的length()方法，
        // 该方法返回类型为int。这里我直接使用了lambda表达式        这里用了成员函数引用，也可以是lambda表达式
        Stream.of("apple","banana","orange","waltermaleon","grape")
                .map(e->e.length()) //转成单词的长度 int
                .forEach(e->System.out.println(e)); //输出
        Stream.of("apple","banana","orange","waltermaleon","grape")
                .map(String::length) //转成单词的长度 int
                .forEach(System.out::println);

        //mapToInt 将数据流中得元素转成Int，这限定了转换的类型Int，最终产生的流为IntStream，及结果只能转化成int。
        Stream.of("apple", "banana", "orange", "waltermaleon", "grape")
                .mapToInt(e -> e.length()) //转成int
                .forEach(e -> System.out.println(e));
        //mapToLong、mapToDouble 与mapToInt 类似
        Stream.of("apple", "banana", "orange", "waltermaleon", "grape")
                .mapToLong(e -> e.length()) //转成long ,本质上是int 但是存在类型自动转换
                .forEach(e -> System.out.println(e));

        //flatmap 作用就是将元素拍平拍扁 ，将拍扁的元素重新组成Stream，并将这些Stream 串行合并成一条Stream
        //flatmapToInt、flatmapToLong、flatmapToDouble 跟flatMap 都类似的，只是类型被限定了
        Stream.of("a-b-c-d","e-f-i-g-h")
                .flatMap(e->Stream.of(e.split("-")))
                .forEach(e->System.out.println(e));

        //limit 限制元素的个数，只需传入 long 类型 表示限制的最大数
        Stream.of(1,2,3,4,5,6)
                .limit(3) //限制三个
                .forEach(e->System.out.println(e)); //将输出 前三个 1，2，3

        Stream.of(1,2,3,1,2,5,6,7,8,0,0,1,2,3,1)
                .distinct() //去重
                .forEach(e->System.out.println(e));

        //filter 对某些元素进行过滤，不符合筛选条件的将无法进入流的下游
        Stream.of(1,2,3,1,2,5,6,7,8,0,0,1,2,3,1)
                .filter(e->e>=5) //过滤小于5的
                .forEach(e->System.out.println(e));


        //peek 挑选 ，将元素挑选出来，可以理解为提前消费
        User w = new User("w",10);
        User x = new User("x",11);
        User y = new User("y",12);

        Stream.of(w,x,y)
                .peek(e->{e.setName(e.getAge()+e.getName());}) //重新设置名字 变成 年龄+名字
                .forEach(e->System.out.println(e.toString()));

        //skip 跳过 元素
        Stream.of(1,2,3,4,5,6,7,8,9)
                .skip(4) //跳过前四个
                .forEach(e->System.out.println(e)); //输出的结果应该只有5，6，7，8，9

        //sorted 排序 底层依赖Comparable 实现，也可以提供自定义比较器
        //这里Integer 实现了比较器
        Stream.of(2,1,3,6,4,9,6,8,0)
                .sorted()
                .forEach(e->System.out.println(e));

    }

    static class User {

        private String name;

        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


}
