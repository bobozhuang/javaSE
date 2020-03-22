package main.java.com.bobozhuang.finaldemo;

/**
 * description：
 * author Hubery
 * date 2020-03-16
 * version v0.0.1
 * since v0.0.1
 **/
//类不能被继承
public final class FinalDemo {

    //不能被修改
    public final String message = "111";

    //不能被重写
    public final void test(){

    }

    //在定义的时候赋值
    //或者在静态代码中
    public static final String test = "12";
    public static final String aaa;
    static {
        aaa="121";
    }

    //类变量赋值时机
    public final String test1="12";
    public final String test2;
    {
        test2="12";
    }
    public final String test3;
    public FinalDemo(){
        test3="123";
    }

    public void test4(final String a) {
        final String b;
        b = "12";
        //b="12";
    }
}
