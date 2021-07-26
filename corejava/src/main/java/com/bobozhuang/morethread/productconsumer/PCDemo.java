package main.java.com.bobozhuang.morethread.productconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * description：     生产者消费者模式通过一个阻塞队列来解决两者之间的强耦合问题。
 *                      阻塞队列相当于一个缓冲区，平衡消费者和生产者的处理能力。
 *                      synchronized+wait+notifyAll
 *
 * author Hubery
 * date 2020-12-09
 * version v0.0.1
 * since v0.0.1
 **/
public class PCDemo {

    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        Product product = new Product(arrayList);
        Consumer consumer = new Consumer(arrayList);
        new Thread(product).start();
        new Thread(consumer).start();
    }
}

class Product implements Runnable {
    private List list;
    private int num = 1;

    public Product(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        //put 1-100的数字·
        while (true) {
            synchronized (list) {
                while (list.size() > 0) {
                    //集合中有数据就停止写入，等待消费者消费完
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (num == 101)
                    return;
                list.add(num++);
                //提示
                System.out.println(Thread.currentThread().getName() + "put的数据：" + list.get(0));
                list.notifyAll();
            }
        }
    }
}


class Consumer implements Runnable {
    private List list;
    private Integer result = 0;


    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                while (list.size() <= 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(10);
                    Integer remove = (Integer) list.remove(0);
                    result = result + remove;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "累加的结果：" + result);
                list.notifyAll();
                if (result == 5050) {
                    return;
                }
            }
        }
    }
}
