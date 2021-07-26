package main.java.com.bobozhuang.day02;

/**
 * description：
 * author Hubery
 * date 2020-12-06
 * version v0.0.1
 * since v0.0.1
 **/
public class User {

    int name;
    String age;
    String email;

    public User(int name, String age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
