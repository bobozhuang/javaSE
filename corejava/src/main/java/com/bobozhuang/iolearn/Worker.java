package main.java.com.bobozhuang.iolearn;

import java.io.Serializable;

/**
 * description：
 * author Hubery
 * date 2020-04-06
 * version v0.0.1
 * since v0.0.1
 **/
public class Worker implements Serializable {

    int id;
    String name;
    boolean gender;

    public Worker(int id, String name, boolean gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
