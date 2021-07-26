package main.java.com.bobozhuang.serialization;

import java.util.Date;

/**
 * description：
 * author Hubery
 * date 5:19 下午 2021/2/22
 * version v0.0.1
 * since v0.0.1
 **/
public class Userc {

    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Userc(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Userc{" +
                "birthday=" + birthday +
                '}';
    }
}
