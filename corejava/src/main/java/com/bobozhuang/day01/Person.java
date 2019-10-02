package main.java.com.bobozhuang.day01;

import java.util.Date;

public class Person {
    public void sayHello() {
        System.out.println("hello~ " + new Date());
    }

    public static void main(String[] args) {
        Person p = new Person();

        p.sayHello();
        byte a = 10;
        byte b = 20;
        int c = a + b;
        System.out.println(c);
    }
}

class A {
}

class B {
}
