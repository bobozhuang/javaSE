package main.java.com.bobozhuang.day01;

//Pojo  plain old java objects
//javabean  框架中
public class Teacher {
    //1 属性，共同特征
    //修饰符  类型 变量名， 类内 方法外
    private int id;
    private String name;
    private boolean gender;
    private double salary;

    //2 无参构造器
    //修饰符 类名(){}
    public Teacher() {

    }

    //3 get/set方法
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //4 普通方法，共同行为
    public void teach() {
        System.out.println(name + " is teaching java!");
    }

}
