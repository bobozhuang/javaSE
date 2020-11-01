package main.java.com.bobozhuang.basic.chap06Stream;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * description：
 * author Hubery
 * date 2020-10-03
 * version v0.0.1
 * since v0.0.1
 **/
public class StreamTest2 {

    public static void main(String[] args) {

        User z = new User("z",10);
        User x = new User("x",11);
        User y = new User("y",12);
        User w = new User("w",10);


        Stream.of(z,w,x,y)
                .sorted((e1,e2)->e1.age>e2.age?1:e1.age==e2.age?0:-1)
                .forEach(e->System.out.println(e.toString()));

        //collect 收集，使用系统提供的收集器可以将最终的数据流收集到List，Set，Map等容器中。
        Stream.of("apple", "banana", "orange", "waltermaleon", "grape")
                .collect(Collectors.toSet()) //set 容器
                .forEach(e -> System.out.println(e));
        //咦？，不是说终止操作符只能使用一次吗，为什么这里调用了forEach 呢？forEach不仅仅是是Stream
        // 中得操作符还是各种集合中得一个语法糖，不信咋们试试。
        Set<String> stringSet = Stream.of("apple", "banana", "orange", "waltermaleon", "grape")
                .collect(Collectors.toSet()); //收集的结果就是set
        stringSet.forEach(e->System.out.println(e)); //set的语法糖forEach

        //count 统计数据流中的元素个数，返回的是long 类型
        long count = Stream.of("apple", "banana", "orange", "waltermaleon", "grape")
                .count();
        System.out.println(count);

        //findFirst 获取流中的第一个元素
        Optional<String> stringOptional = Stream.of("apple", "banana", "orange", "waltermaleon", "grape")
                .findFirst();
        stringOptional.ifPresent(e->System.out.println(e));

        //findAny 获取流中任意一个元素
        Optional<String> optionalS = Stream.of("apple", "banana", "orange", "waltermaleon", "grape")
                .parallel()
                .findAny(); //在并行流下每次返回的结果可能一样也可能不一样
        optionalS.ifPresent(e->System.out.println(e));

        //noneMatch 数据流中得没有一个元素与条件匹配的
        //这里 的作用是是判断数据流中 一个都没有与aa 相等元素 ，但是流中存在 aa ，所以最终结果应该是false
        //allMatch和anyMatch 一个是全匹配，一个是任意匹配 和noneMatch 类似
        boolean result = Stream.of("aa","bb","cc","aa")
                .noneMatch(e->e.equals("aa"));
        System.out.println(result);

        //min 最小的一个，传入比较器，也可能没有(如果数据流为空),max 元素中最大的
        Optional<Integer> integerOptional = Stream.of(0,9,8,4,5,6,-1)
                .min((e1,e2)->e1.compareTo(e2));

        integerOptional.ifPresent(e->System.out.println(e));

        //forEachOrdered 适用用于并行流的情况下进行迭代，能保证迭代的有序性
        //这里通过并行的方式输出数字
        Stream.of(0,2,6,5,4,9,8,-1)
                .parallel()
                .forEachOrdered(e->{
                    System.out.println(Thread.currentThread().getName()+": "+e);});

        //toArray 转成数组，可以提供自定义数组生成器
        Object[] objects=Stream.of(0,2,6,5,4,9,8,-1)
                .toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

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
