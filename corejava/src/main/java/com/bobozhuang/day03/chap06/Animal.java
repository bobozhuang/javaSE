package main.java.com.bobozhuang.day03.chap06;

public class Animal {
    public int id;
    protected String name;
    boolean gender;
    private double weight;

    public void eat() {
        System.out.println("eat");
    }

    protected void sleep() {
        System.out.println("sleep");
    }

    void play() {
        System.out.println("play");
    }

    private void takeSh() {
        System.out.println("takeSh");
    }

    public Animal(int i) {
        System.out.println("Animal()");
    }

    public Animal() {
    }
}
