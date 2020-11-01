package main.java.com.bobozhuang.reflection;

import java.lang.reflect.Method;

/**
 * description： Method类
 *               代表类（不是对象）中的某一方法。
 * author Hubery
 * date 2020-10-13
 * version v0.0.1
 * since v0.0.1
 **/
public class ReflectionTest5 {

    public static void main(String[] args) throws SecurityException, NoSuchMethodException, NoSuchFieldException, IllegalArgumentException, Exception {
        String str = "shfsfs";
        //包开头是com表示是sun内部用的，java打头的才是用户的
        Method mtCharAt = String.class.getMethod("charAt", int.class);
        Object ch = mtCharAt.invoke(str,1);//若第一个参数是null，则肯定是静态方法
        System.out.println(ch);

        System.out.println(mtCharAt.invoke(str, new Object[]{2}));//1.4语法

    }

}
