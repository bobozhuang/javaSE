package main.java.com.bobozhuang.day01;

public class OperationTest {
    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        System.out.println(i++);
        System.out.println(++i);
        Object o = new Teacher();
        System.out.println
                (o instanceof Teacher);
        System.out.println(i == j);
        Teacher t1 = new Teacher();
        Teacher t2 = new Teacher();
        t1.setName("rose");
        t2.setName("rose");
        System.out.println(t1 == t2);
        System.out.println(12 % 3.14);
        System.out.println(12 >> 2);
        System.out.println(-12 >> 2);
        System.out.println(12 >>> 2);
        System.out.println(-12 >>> 2);
        System.out.println(12 << 2);
        System.out.println(-12 << 2);
        System.out.println(12 & 8);
        System.out.println(12 | 8);
        System.out.println(12 ^ 8);
        System.out.println(~12);
        System.out.println("-----------");

        int m = 10;
        int n = 20;
        if (m++ > 100 && n++ < 50) {
        }
        System.out.println("&&:" + m + " " + n);

        System.out.println(16* 2 /3);   //16 10

    }
}
