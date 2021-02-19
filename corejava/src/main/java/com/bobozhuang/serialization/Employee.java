package main.java.com.bobozhuang.serialization;

/**
 * description：
 * author Hubery
 * date 6:17 下午 2021/2/18
 * version v0.0.1
 * since v0.0.1
 **/
public class Employee {

    private int code;
    private String position;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employee(int code, String position) {
        this.code = code;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "code=" + code +
                ", position='" + position + '\'' +
                '}';
    }
}
