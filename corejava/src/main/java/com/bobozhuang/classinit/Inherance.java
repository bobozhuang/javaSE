package main.java.com.bobozhuang.classinit;

/**
 * description：     类初始化
 * author Hubery
 * date 2020-05-29
 * version v0.0.1
 * since v0.0.1
 **/
public class Inherance {
    public static void main(String[] args){
        ChildClass clazz = new ChildClass();
        ChildClass.staticMethod();
        clazz.method();
    }
}
class ParentClass{
    public ParentClass(){
        System.out.println("A");
    }
    public static void staticMethod(){
        System.out.println("B");
    }
    public void method(){
        System.out.println("C");
    }
}
class ChildClass extends ParentClass{
    public ChildClass(){
        System.out.println("X");
    }
    public static void staticMethod(){
        System.out.println("Y");
    }
    public void method(){
        System.out.println("Z");
    }
}
