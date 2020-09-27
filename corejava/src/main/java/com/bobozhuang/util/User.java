package main.java.com.bobozhuang.util;

/**
 * description：
 * author Hubery
 * date 2020-09-23
 * version v0.0.1
 * since v0.0.1
 **/
public class User {

    Integer id;

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }
}
