package main.java.com.bobozhuang.exam.chap02;

/**
 * description：
 * author Hubery
 * date 2020-08-08
 * version v0.0.1
 * since v0.0.1
 **/
public class MyClass {
    long var;
    public void MyClass(long param) { var = param; }//(1)
    public static void main(String[] args) {
        MyClass a, b;
        a =new MyClass();//(2)
        //b =new MyClass(5);//(3)
    }


}
