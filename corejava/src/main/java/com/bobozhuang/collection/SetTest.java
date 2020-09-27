
package main.java.com.bobozhuang.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;


/**
 * 在迭代过程中调用集合的 remove(Object o) 可能会报 java.util.ConcurrentModificationException 异常
 * forEachRemaining 方法中 调用Iterator 的 remove 方法会报 java.lang.IllegalStateException 异常
 *
 */
public class SetTest {
    //无序，不可重复的数据
    public static void main(String[] args) {
        Set set = new HashSet();
        Student s1 = new Student(101, "张三", true);
        Student s2 = new Student(101, "李四", true);
        Student s3 = new Student(101, "张三", false);

        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(null);
        System.out.println
                ("set集合中元素个数:" + set.size());
        Iterator ite = set.iterator();
        while (ite.hasNext()) {
            Object o = ite.next();

            System.out.println(o);
            if (null == o){
                //set.remove(o);//ConcurrentModificationException  通过调用集合的remove方法在遍历删除的时候会抛异常
                ite.remove();       //使用迭代器的remove方法不会抛异常
            }
        }
        System.out.println("----" + set.toString());
        //再去获取下一个就没有了
        while (ite.hasNext()) {
            Object o = ite.next();
            System.out.println(o);
        }
        ArrayList<String> aList = new ArrayList<String>();
        aList.add("111");
        aList.add("333");
        aList.add("222");
        Iterator<String> iterator = aList.iterator();
        iterator.forEachRemaining(new Consumer<String>() {
            public void accept(String t) {
                System.out.println(t);
                if ("222".equals(t)) {
                    iterator.remove();
                }
            }
        });

    }
}