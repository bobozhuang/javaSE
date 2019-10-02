package main.java.com.bobozhuang.day03.chap07;

public class GenderTest {
    public static void main(String[] args) {

        Gender m = Gender.MALE;
        Gender f = Gender.FEMALE;
        Gender m1 = Gender.valueOf("MALE");
        Gender f1 = Gender.valueOf("FEMALE");
        System.out.println(m == m1);
        System.out.println(f == f1);
        m.getName();
        m.looklike();
    }
}
