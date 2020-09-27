package main.java.com.bobozhuang.designpattern.proxy.dynamicproxy;

/**
 * description：
 * author Hubery
 * date 2020-08-19
 * version v0.0.1
 * since v0.0.1
 **/
public class StudentServiceImpl implements IStudentService {
    public void delete(long id) {
        System.out.println("student was deleted...");
    }

    public Student find(long id) {
        System.out.println("student was found...");
        return null;
    }

    public void save(Student s) {
        System.out.println("student was saved...");
    }
}
