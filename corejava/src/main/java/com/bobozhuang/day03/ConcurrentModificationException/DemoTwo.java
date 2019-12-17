package main.java.com.bobozhuang.day03.ConcurrentModificationException;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * description��
 *      ���Կ��Կ�����CopyOnWriteArrayList��ִ��Ч��û��ArrayList��Ч�ʸߣ������ȷ��Ҫ��һ��List�����޸ģ���ôCopyOnWriteArrayList��һ���õ�ѡ��
 *
 *      �����Listû���޸ĵ����󣬽���ʹ��ArrayList��
 *
 * author Hubery
 * date 2019-12-16
 * version v0.0.1
 * since v0.0.1
 **/
public class DemoTwo {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> a = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10; i++) {
            a.add("==> " + String.valueOf(i));
        }

        for (String b : a) {
            System.out.println(b);
            a.remove(0);            //CopyOnWriteArrayList��remove��ʵ��
        }

        System.out.println(a.size());

    }
}
