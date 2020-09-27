package main.java.com.bobozhuang.stringDemo;


/**
 * description��
 * author Hubery
 * date 2019-10-21
 * version v0.0.1
 * since v0.0.1
 **/
public class StringNullPointer {

    public static void main(String[] args) {
        String str = "abcereadf";
        str = null;
        String[] split = str.split("z");

        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
        System.out.println("���͹�����");

    }

}
