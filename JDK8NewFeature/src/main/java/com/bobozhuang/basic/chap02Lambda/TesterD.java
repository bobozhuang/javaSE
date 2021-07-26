package main.java.com.bobozhuang.basic.chap02Lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description：
 * author Hubery
 * date 2020-11-17
 * version v0.0.1
 * since v0.0.1
 **/
public class TesterD {
    public static void main(String[] args) {

        ArrayList<Object> arrayList = new ArrayList<>();
        User f = new User(5, "f");
        arrayList.add(new User(5,"a"));
        arrayList.add(new User(6,"b"));
        arrayList.add(new User(5,"c"));
        arrayList.add(new User(6,"d"));
        arrayList.add(new User(5,"e"));
        arrayList.add(f);
        arrayList.forEach(user -> {
            boolean equals = f.equals(user);
            if (equals==true){
                System.out.println(user.toString());
            }
        });


    }

    static void test1(){
        //使用 forEach + lambda 表达式或方法引用循环 List。
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");

        //lambda
        //Output : A,B,C,D,E
        items.forEach(item->System.out.println(item));

        //Output : C
        items.forEach(item->{
            if("C".equals(item)){
                System.out.println(item);
            }
        });

        //method reference
        //Output : A,B,C,D,E
        items.forEach(System.out::println);

        //Stream and filter
        //Output : B
        items.stream()
                .filter(s->s.contains("B"))
                .forEach(System.out::println);
    }


    static void test2(){
        //使用 forEach + lambda 表达式循环 Map。
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));

        items.forEach((k,v)->{
            System.out.println("Item : " + k + " Count : " + v);
            if("E".equals(k)){
                System.out.println("Hello E");
            }
        });
    }

}

class User{
    int age;
    String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age = " + age +
                ", name = '" + name + '\'' +
                '}';
    }
}
