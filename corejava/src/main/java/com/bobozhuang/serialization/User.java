package main.java.com.bobozhuang.serialization;

import java.io.Serializable;

public class User implements Serializable {

    /** 显示增加序列版本UUID，自动生成UUID可能会导致InvalidClassException */
    private static final long serialVersionUID = -6300357708513313750L;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

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
