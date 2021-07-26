package main.java.com.bobozhuang.morethread.lock;

/**
 * description：
 * author Hubery
 * date 2020-09-22
 * version v0.0.1
 * since v0.0.1
 **/
public class Student {

    private String name;

    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
