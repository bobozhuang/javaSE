package main.java.com.bobozhuang.exam;

import java.util.ArrayList;
import java.util.List;

/**
 * description：
 * 一个含有n个数字的序列x1,x2,x3,…xn，可以进行以下操作：
 * 一次操作定义为对这个序列的每个数字进行以下两种改变之一：
 * 1.xi ÷ 2
 * 2.xi × 3
 * 每一次的操作中，必须保证至少有一个数字是第1种改变；并且经过每次操作后，每一个数字都必须是整数。
 * author Hubery
 * date 2020-03-15
 * version v0.0.1
 * since v0.0.1
 **/
public class Exam20200315_47 {

    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.set(i,i);
        }
        Exam20200315_47 e = new Exam20200315_47();
        boolean result = true;
        result = e.operate(list);

    }

    private boolean operate(List list){
        boolean result = true;
        int flag =0;
        for (int i = 0; i < list.size(); i++) {
            flag = changeOne(list.indexOf(i));
            if (flag == i){
                list.set(i,changeTwo(list.indexOf(i)));
                result = false;
            }
            list.set(i,changeTwo(list.indexOf(i)));
        }
        if (!result){
            return false;
        }
        return result;
    }

    private int changeOne(int i){
        int a =i%2;
        if (a!=0){
            return a;
        }
        return i;
    }

    private int changeTwo(int i){
        return i*3;
    }
    private int Exam20200315_47(int i){
        return i*3;
    }

}
