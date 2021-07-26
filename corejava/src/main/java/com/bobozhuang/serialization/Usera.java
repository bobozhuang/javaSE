package main.java.com.bobozhuang.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * description：
 * author Hubery
 * date 6:57 下午 2021/2/19
 * version v0.0.1
 * since v0.0.1
 **/
public class Usera implements Serializable {

    private static int count = 1;

    public Usera(String password, int id, String name) {
        // 约束条件name不能为null
        if (name == null || name == "") {
            throw new NullPointerException("name is null");
        }
        this.password = password;
        this.id = id;
        this.name = name;
    }

    public Usera(){};

    private transient String password;
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Usera{" +
                "password='" + password + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Usera.count = count;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    private void readObject(ObjectInputStream inputStream)
            throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        System.out.println("defaultReadObject");
        // 约束条件name不能为null
        if (name == null || name == "") {
            throw new NullPointerException("name is null");
        }
    }

}
