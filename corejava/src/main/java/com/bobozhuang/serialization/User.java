package main.java.com.bobozhuang.serialization;

import java.io.Serializable;

public class User implements Serializable {

    /** 显示增加序列版本UUID，自动生成UUID可能会导致InvalidClassException */
    private static final long serialVersionUID = 3L;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }
    //在反序列化的时候我在这个类多加了一个构造函数，他就会报错
    /*public User(int id) {
        this.id = id;
    }*/

    private int id;
    private String name;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
