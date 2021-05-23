package main.java.com.bobozhuang.serialization;

/**
 * description：
 * author Hubery
 * date 4:44 下午 2021/2/22
 * version v0.0.1
 * since v0.0.1
 **/
public class Userb {

    private transient String password;
    private int id;
    private String name;
    private Employee employee;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Userb{" +
                "password='" + password + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", employee=" + employee +
                '}';
    }
}
