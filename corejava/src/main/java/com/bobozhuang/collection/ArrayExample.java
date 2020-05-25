package main.java.com.bobozhuang.collection;

import java.util.ArrayList;

/**
 * description：
 * author Hubery
 * date 2020-05-21
 * version v0.0.1
 * since v0.0.1
 **/
public class ArrayExample {

    public static void main(String[] args)
    {
        ArrayList<String> strList = new ArrayList<String>();
        strList.ensureCapacity(3);
        strList.trimToSize();
        strList.add(0, "A");
        strList.add(1, "B");
        strList.add(2, "C");
        strList.add(3, "D");
        strList.add("E");
        for(int i=0;i<strList.size();i++)
        {
            System.out.println(strList.get(i));
        }

        int x = Integer.parseInt("34");
        System.out.println(Integer.reverse(x));

        //System.out.printf("%d %s",23);
        System.out.printf("%d",23);
    }

}
