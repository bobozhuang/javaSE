package main.java.com.bobozhuang.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * description��     list ��������
 * author Hubery
 * date 2019-11-19
 * version v0.0.1
 * since v0.0.1
 **/
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("java");
        arrayList.add("java");
        arrayList.add("java");
        arrayList.add("java");
        arrayList.add("java");
        arrayList.add("python");
        arrayList.add("java");
        arrayList.add("java");
        arrayList.add("java");

        arrayList.add("php");
        arrayList.add("java");
        arrayList.add("java");
        arrayList.add("java");
        arrayList.add("java");
        arrayList.add("Golang");
        arrayList.add("java");
        arrayList.add("java");
        arrayList.add("java");
        List b = new ArrayList();
        //���� = ֱ�Ӹ�ֵ��add��Ӷ���ǳ������ֻҪ�޸ļ��ϵ�ֵ���������϶�����
        // b = arrayList;
        //b.add(arrayList);
        // addAll�����
        b.addAll(arrayList);

        arrayList.add(9,"mmp");

        System.out.println(b.toString());
        System.out.println("-");
        System.out.println(arrayList.toString());

        System.out.println(arrayList.contains("php"));

    }
}
