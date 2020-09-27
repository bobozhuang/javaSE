package main.java.com.bobozhuang.collection.queue.priorityqueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * description：     https://blog.csdn.net/u013673252/article/details/84523949
 * priorityBlockingQueue是一个无界队列，它没有限制，在内存允许的情况下可以无限添加元素；
 * 它又是具有优先级的队列，是通过构造函数传入的对象来判断，传入的对象必须实现comparable接口。
 * <p>
 * 每次添加一个元素，PriorityBlockingQueue中的person都会执行compareTo方法进行排序，但是只是把第一个元素排在首位，
 * 其他元素按照队列的一系列复杂算法排序。这就保障了每次获取到的元素都是经过排序的第一个元素。
 * <p>
 * 队列中的顺序不是 按照 compareTo 排序的，只是在每次放add元素时排序，再放 元素是就又会乱掉
 * 每次take获取的元素都是排序后第一个元素。
 * <p>
 * author Hubery
 * date 2020-09-15
 * version v0.0.1
 * since v0.0.1
 **/

public class Person implements Comparable<Person> {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return this.id + ":" + this.name;
    }

    @Override
    public int compareTo(Person person) {
        return this.id > person.getId() ? 1 : (this.id < person.getId() ? -1 : 0);
    }

    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Person> pbq = new PriorityBlockingQueue<>();
        Person person31 = new Person(3, "person3");
        pbq.add(person31);
        System.err.println("容器为：" + pbq);
        pbq.add(new Person(2, "person2"));
        System.err.println("容器为：" + pbq);
        pbq.add(new Person(1, "person1"));
        System.err.println("容器为：" + pbq);
        pbq.add(new Person(4, "person4"));
        System.err.println("容器为：" + pbq);
        //将指定的元素插入到此优先级队列中
        pbq.offer(new Person(7, "person7"));
        pbq.put(new Person(6, "person6"));
        System.err.println("容器为：" + pbq);
        System.err.println("分割线----------------------------------------------------------------");
        //检索但不删除此队列的头，如果此队列为空，则返回 null 。
        Person peek = pbq.peek();
        System.err.println("peek 为：" + peek);
        boolean person3 = pbq.remove(person31);
        System.err.println(person3 + " remove：" + pbq);
        Person take = null;
        try {
            //检索并删除此队列的头，如有必要，等待元素可用。
            take = pbq.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("take为：" + take);
        while (pbq.size() > 0) {
            try {
                pbq.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.err.println("分割线----------------------------------------------------------------");

        pbq.add(new Person(3, "person3"));
        System.err.println("容器为：" + pbq);
        pbq.add(new Person(2, "person2"));
        System.err.println("容器为：" + pbq);
        pbq.add(new Person(1, "person1"));
        System.err.println("容器为：" + pbq);
        pbq.add(new Person(4, "person4"));
        System.err.println("容器为：" + pbq);
        System.err.println("分割线----------------------------------------------------------------");


        System.err.println("获取元素 " + pbq.take().getId());
        System.err.println("容器为：" + pbq);
        System.err.println("分割线----------------------------------------------------------------");

        System.err.println("获取元素 " + pbq.take().getId());
        System.err.println("容器为：" + pbq);
        System.err.println("分割线----------------------------------------------------------------");

        System.err.println("获取元素 " + pbq.take().getId());
        System.err.println("容器为：" + pbq);
        System.err.println("分割线----------------------------------------------------------------");

        System.err.println("获取元素 " + pbq.take().getId());
        System.err.println("容器为：" + pbq);
        System.err.println("分割线----------------------------------------------------------------");

        pbq.offer(new Person(5, "person5"));
        pbq.offer(new Person(1, "person1"));
        pbq.offer(new Person(4, "person4"));
        pbq.offer(new Person(3, "person3"));
        pbq.offer(new Person(2, "person2"));

        System.err.println("容器为：" + pbq);
        pbq.clear();
        System.err.println("分割线----------------------------------------------------------------");
        pbq.put(new Person(5, "person5"));
        pbq.put(new Person(1, "person1"));
        pbq.put(new Person(4, "person4"));
        pbq.put(new Person(2, "person2"));
        pbq.put(new Person(3, "person3"));
        int i = 0;
        while (i < 9) {
            System.err.println("获取元素 " + pbq.take());
        }
        System.err.println("容器为：" + pbq);
    }

}
