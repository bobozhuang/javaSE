package main.java.com.bobozhuang.day01;

public class VariableTest {
    int i;
    float f;
    double d;
    char c;
    boolean b;

    public void test() {
        //int i;
        float f;
        double d;
        char c;
        boolean b;
        System.out.println(this.i);
        System.out.println(this.f);
        System.out.println(this.d);
        System.out.println(this.c);
        System.out.println(this.b);
        System.out.println("-------------");
    }

    public static void main(String[] args) {
        new VariableTest().test();

    }

}
