package main.java.com.bobozhuang.day01;

/**
 * description��
 * author Hubery
 * date 2019-11-06
 * version v0.0.1
 * since v0.0.1
 **/
public class MathTest {
    private static final byte mask = 3;

    public static void main(String[] args) {

        long round = Math.round(-1.5);
        System.out.println("round1 : " + round);
        System.out.println("round2 : " + Math.round(1.5));

        int i = 1;
        for (int a = 1; a <= 32; a++) {
            i = i * 2;
            System.out.println(a + ": " + i);
        }

        System.out.println("12121212----12--12-12-");
        System.out.println(Integer.SIZE);
        System.out.println(1 << (Integer.SIZE - mask));
    }
}
