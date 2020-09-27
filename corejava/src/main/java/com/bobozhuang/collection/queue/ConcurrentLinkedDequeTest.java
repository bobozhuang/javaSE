package main.java.com.bobozhuang.collection.queue;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * description： 创建100个线程将数据添加到列表和100个线程从列表删除数据。如果真的是线程安全的和非阻塞,它会几乎立即给你最终结果。
 *              此外,列表大小最终将是零。
 * author Hubery
 * date 2020-08-27
 * version v0.0.1
 * since v0.0.1
 **/
public class ConcurrentLinkedDequeTest {

    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
        Thread threads[] = new Thread[2];

        for (int i = 0; i < threads.length; i++) {
            AddTask task = new ConcurrentLinkedDequeTest.AddTask(list);
            threads[i] = new Thread(task);
            threads[i].setName("AddTask   " + i);
            threads[i].start();
        }
        System.out.printf("Main: %d AddTask threads have been launched\n", threads.length);

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: Size of the List: %d\n", list.size());

        for (int i = 0; i < threads.length; i++) {
            RemoveTask task = new RemoveTask(list);
            threads[i] = new Thread(task);
            threads[i].setName("RemoveTask " + i);
            threads[i].start();
        }
        System.out.printf("Main: %d RemoveTask threads have been launched\n", threads.length);

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: Size of the List: %d\n", list.size());
    }


    static class AddTask implements Runnable {

        private ConcurrentLinkedDeque<String> list;

        public AddTask(ConcurrentLinkedDeque<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                //在此deque的尾部插入指定的元素。
                list.add(name + ": addElement " + i);
                //在此deque前面插入指定的元素。
                list.addFirst(name + ": addFirstElement " + i);
                //在此deque的末尾插入指定的元素。
                list.addLast(name + ": addLastElement " + i);
                //在此deque的尾部插入指定的元素
                list.offer(name + ": offerElement " + i);
                //在此deque前面插入指定的元素。
                list.offerFirst(name + ": offerLastElement " + i);
                //在此deque的末尾插入指定的元素。
                list.offerLast(name + ": offerLastElement " + i);
                //将元素推送到由此deque代表的堆栈（换句话说，在该deque的头部），如果可以立即执行，
                // 而不违反容量限制，则抛出 IllegalStateException如果当前没有可用空间）。
                list.push(name + ": pushElement " + i);

            }
        }
    }


    static class RemoveTask implements Runnable {

        private ConcurrentLinkedDeque<String> list;

        public RemoveTask(ConcurrentLinkedDeque<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            //检索但不删除由此deque表示的队列的头部（换句话说，该deque的第一个元素）。
            System.out.println("check : " + list.element());
            //检索，但不删除，这个deque的第一个元素。
            System.out.println("check : " + list.getFirst());
            //检索，但不删除，这个deque的最后一个元素。
            System.out.println("check : " + list.getLast());
            //检索但不删除由此deque表示的队列的头（换句话说，该deque的第一个元素），如果此deque为空，则返回 null 。
            System.out.println("check : " + list.peek());
            //检索但不删除此deque的第一个元素，如果此deque为空，则返回 null 。
            System.out.println("check : " + list.peekFirst());
            //检索但不删除此deque的最后一个元素，如果此deque为空，则返回 null 。
            System.out.println("check : " + list.peekLast());
            for(int i = 0; i < 5; i++) {
                //检索并删除由此deque表示的队列的头部（换句话说，该deque的第一个元素），如果此deque为空，则返回 null 。
                System.out.println("删除poll " + list.poll());
                //检索并删除此deque的第一个元素，如果此deque为空，则返回 null 。
                System.out.println("删除pollFirst " + list.pollFirst());
                System.out.println("删除pollLast " + list.pollLast());
                //从这个deque表示的堆栈中弹出一个元素。
                System.out.println("删除pop " + list.pop());
                //检索并删除由此deque表示的队列的头（换句话说，该deque的第一个元素）。
                System.out.println("删除remove " + list.remove());
                //删除第一个元素 e ，使 o.equals(e) ，如果这样一个元素存在于这个deque。
                System.out.println( "删除remove(o) " + list.remove(name + ": pushElement " + i)); //最好判断一下
                //检索并删除此deque的第一个元素。
                System.out.println("删除remove(o) " + list.removeFirst());
                //检索并删除此deque的最后一个元素。
                System.out.println("删除removeLast " + list.removeLast());
                //删除最后一个元素 e ，使 o.equals(e) ，如果这样的元素存在于这个deque。
                System.out.println("删除removeLastOccurrence(o) " + list.removeLastOccurrence(name + ": pushElement " + i));

            }
        }
    }


}
