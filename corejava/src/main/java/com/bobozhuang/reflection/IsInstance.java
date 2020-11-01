package main.java.com.bobozhuang.reflection;

/**
 * description：     模拟 instanceof 操作符
 * author Hubery
 * date 2020-10-13
 * version v0.0.1
 * since v0.0.1
 **/
public class IsInstance {

    public static void main(String args[]) {
        try {
            Class cls = Class.forName("main.java.com.bobozhuang.reflection.S");
            boolean b1 = cls.isInstance(new Integer(37));
            System.out.println(b1);
            boolean b2 = cls.isInstance(new S());
            System.out.println(b2);
        }
        catch (Throwable e) {
            System.err.println(e);
        }
    }

}

class S {
}



