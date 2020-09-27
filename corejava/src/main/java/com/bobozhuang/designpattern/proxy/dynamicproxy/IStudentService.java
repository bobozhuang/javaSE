package main.java.com.bobozhuang.designpattern.proxy.dynamicproxy;

/**
 * description：
 * author Hubery
 * date 2020-08-19
 * version v0.0.1
 * since v0.0.1
 **/
public interface IStudentService {

    void save(Student s);

    void delete(long id);

    Student find(long id);


}
