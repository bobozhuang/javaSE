package main.java.com.bobozhuang.day03.ConcurrentModificationException;

import java.util.ArrayList;
import java.util.List;

/**
 * description��ArrayList��һ���̰߳�ȫ�ı��壬�����пɱ������add��set �ȣ�����ͨ���Եײ��������һ���µĸ�����ʵ�ֵġ�
 *                  ����ArrayList��remove��ʵ��
 *
 *                  https://blog.csdn.net/enlangs/article/details/20655255
 * author Hubery
 * date 2019-12-12
 * version v0.0.1
 * since v0.0.1
 **/
public class DemoOne {
    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            a.add("==> " + String.valueOf(i));
        }

        for (String b : a) {
            System.out.println(b);
            a.remove(0);        //�鿴Դ��
        }

    }
}
