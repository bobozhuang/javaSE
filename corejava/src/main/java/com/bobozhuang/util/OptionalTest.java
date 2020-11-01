package main.java.com.bobozhuang.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * description：
 * author Hubery
 * date 2020-09-23
 * version v0.0.1
 * since v0.0.1
 **/
public class OptionalTest {

    public static void main(String[] args) {
        //Integer i = new Integer(2);
        Integer i = null;
        Optional.ofNullable(i).ifPresent(t -> t = 3);
        System.out.println(i);

        int j = 150;
        Optional.ofNullable(j).ifPresent(t -> t = 256);
        System.out.println(j);


        User user = new User(1);
        Optional.ofNullable(user).ifPresent(t -> t = new User(2));
        System.out.println(user.toString());

        Map map = new HashMap<>();
        map.put("a", "1");
        Optional.ofNullable(map).ifPresent(t -> {
            Map a = new HashMap();
            a.put("b", "2");
                }
        );
        System.out.println(map);
    }


    /**
     * 值传递
     */
    @Test
    public void test1() {
        Integer i = 1;
        change(i);
        // 输出1
        System.out.println(i);
    }

    public void change(int i) {
        i = i * 2;
    }

    /**
     * 引用传递，即一个方法可以改变一个对象参数的状态
     */
    @Test
    public void test2() {
        User u = new User(1);
        change2(u);
        // 输出2
        System.out.println(u.getId());
    }

    public void change2(User u) {
        u.setId(2);
    }

    /**
     * 引用传递，即一个方法不能让对象参数引用一个新的对象
     */
    @Test
    public void test3() {
        User u = new User(1);
        change3(u);
        // 输出1
        System.out.println(u.getId());
    }

    public void change3(User u) {
        u = new User(2);
    }
}
