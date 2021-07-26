package main.java.com.bobozhuang.collection;

import java.util.*;

/**
 * description：
 * author Hubery
 * date 2020-11-04
 * version v0.0.1
 * since v0.0.1
 **/
public class ListTest2 {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.addFirst("0");
        linkedList.addLast("d");
        for (int i = 0; i<linkedList.size();i++){
            System.out.println(linkedList.get(i));
        }
        System.out.println("-------------");
        for (Object str :
                linkedList) {
            System.out.println(str);
        }
        System.out.println("-------------");
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        List<Object> arrayList = new ArrayList<>();
        arrayList.addAll(linkedList);
        System.out.println(arrayList.get(3));

        List<Object> synchronizedList = Collections.synchronizedList(arrayList);

    }
}
