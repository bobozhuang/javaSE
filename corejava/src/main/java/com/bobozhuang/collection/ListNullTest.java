package main.java.com.bobozhuang.collection;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * description：
 * author Hubery
 * date 2020-04-26
 * version v0.0.1
 * since v0.0.1
 **/
public class ListNullTest {

    public static void main(String[] args) {
        ArrayList a = null;
        ArrayList arr = new ArrayList();
//        boolean empty = a.isEmpty();
//        System.out.println(empty);
//        System.out.println(arr);

        HashMap<Object, Object> map = new HashMap<>();
        Object ha = map.get("ha");
        System.out.printf("" + ha);
    }

}
