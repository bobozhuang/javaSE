package main.java.com.bobozhuang.day01;

public class TeacherTest {
    public static void main(String[] args) {
        //1 如何拿到这个类的对象
        // 类类型/引用类型
        Teacher t = new Teacher();
        //2 如何访问属性
//        System.out.println(t.id+" "+t.name);
        t.setId(101);
        t.setName("Jack");
        System.out.println
                (t.getId() + " " + t.getName());

        //3 如何调用方法
        //某个类的对象，能调用到的
        //方法只能是这个类中声明过的
        t.teach();

    }
}
