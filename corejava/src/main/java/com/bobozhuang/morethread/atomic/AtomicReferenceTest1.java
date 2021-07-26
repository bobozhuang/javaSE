package main.java.com.bobozhuang.morethread.atomic;


import main.java.com.bobozhuang.morethread.lock.Student;

import java.util.concurrent.atomic.AtomicReference;

/**
 * description：
 * author Hubery
 * date 2020-09-22
 * version v0.0.1
 * since v0.0.1
 **/
public class AtomicReferenceTest1 {
    public final static AtomicReference<Student> atomicStudent = new AtomicReference<Student>();

    public static void main(String[] args) {

        final Student student1 = new Student("a", 1);
        final Student student2 = new Student("b", 2);

        //初始值为student1对象
        atomicStudent.set(student1);

        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    try {
                        //为了 使得控制台打印的 更改student1的线程 能显示出不一样 每个线程随机停顿 多执行几次能看出效果
                        Thread.sleep(Math.abs((int) Math.random() * 100));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //预期值 student1和 当前值（上面的atomicStudent.set(student1);）相等时候 赋予student2新的值
                    if (atomicStudent.compareAndSet(student1, student2)) {
                        System.out.println(Thread.currentThread().getId() + " Change value");
                        System.out.println(atomicStudent.get().getName() + " : " + atomicStudent.get().getAge());
                    } else {
                        System.out.println(Thread.currentThread().getId() + " Failed");
                    }
                }

                ;
            }.start();
        }
    }

}
