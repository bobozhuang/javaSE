package main.java.com.bobozhuang.ObjectCopy.shallow;

/**
 * description：
 * author Hubery
 * date 2020-04-27
 * version v0.0.1
 * since v0.0.1
 **/
public class ClassRoom
        implements Cloneable {
    public String name;
    public int studentNum;
    public Student student;

    public ClassRoom(String name, int studentNum, Student student) {
        this.name = name;
        this.studentNum = studentNum;
        this.student = student;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "name='" + name + '\'' +
                ", studentNum=" + studentNum +
                ", student=" + student +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
