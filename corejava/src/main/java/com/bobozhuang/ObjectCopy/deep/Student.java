package main.java.com.bobozhuang.ObjectCopy.deep;

/**
 * description：
 * author Hubery
 * date 2020-04-27
 * version v0.0.1
 * since v0.0.1
 **/
public class Student implements Cloneable {
    public String name;
    public int age;
    public boolean isBoy;

    public Student(String name, int age, boolean isBoy) {
        this.name = name;
        this.age = age;
        this.isBoy = isBoy;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isBoy=" + isBoy +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
