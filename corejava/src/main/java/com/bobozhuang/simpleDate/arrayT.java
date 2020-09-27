package main.java.com.bobozhuang.simpleDate;

import main.java.com.bobozhuang.util.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 数组，数组转List
 */
public class arrayT {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {1, 4, 56, 6};
        String s = Arrays.toString(arr);
        System.out.println(s + "a");

        //数组转换为list集合
        List<int[]> ints = Arrays.asList(arr);
        //将list集合转换为数组Array
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        ls.add(5);
        Object[] objects = ls.toArray();

        User[] array = {new User(1), new User(2)};   //定义一个数组
        List<User> list = new ArrayList<User>(array.length);  //设置ArrayList的初始容量
        Collections.addAll(list, array);

    }

}
