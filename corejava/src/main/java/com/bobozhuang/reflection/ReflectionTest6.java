package main.java.com.bobozhuang.reflection;

import java.util.Arrays;

/**
 * description：     从这个例子看出即便字节码相同但是对象也不一定相同,根本不是一回事
 *
 *              Array工具类用于完成数组的反射操作。
 *
 *              同类型同纬度有相同的字节码。
 *
 *              int.class和Integer.class不是同一份字节码，Integer.TYPE，TYPE代表包装类对应的基本类的字节码 int.class==Integer.TYPE。
 *
 * author Hubery
 * date 2020-10-13
 * version v0.0.1
 * since v0.0.1
 **/
public class ReflectionTest6 {

    public static void main(String[] args) throws SecurityException, NoSuchMethodException, NoSuchFieldException, IllegalArgumentException, Exception {
        int[] a = new int[3];
        int[] b = new int[]{4,5,5};//直接赋值后不可以指定长度，否则ＣＥ
        int[][] c = new int[3][2];
        String[] d = new String[]{"jjj","kkkk"};
        System.out.println(a==b);//false
        System.out.println(a.getClass()==b.getClass());//true
        //System.out.println(a.getClass()==d.getClass());    //比较字节码a和cd也没法比
        System.out.println(a.getClass());//输出class [I
        System.out.println(a.getClass().getName());//输出[I,中括号表示数组，I表示整数

        System.out.println(a.getClass().getSuperclass());//输出class java.lang.Object
        System.out.println(d.getClass().getSuperclass());//输出class java.lang.Object

        //由于父类都是Object,下面都是可以的
        Object obj1 = a;//不可是Object[]
        Object obj2 = b;
        Object[] obj3 = c;//基本类型的一维数组只可以当做Object，非得还可以当做Object[]
        Object obj4 = d;

        //注意asList处理int[]和String[]的区别
        System.out.println(Arrays.asList(b));//1.4没有可变参数，使用的是数组,[[I@1bc4459]
        System.out.println(Arrays.asList(d));//[jjj, kkkk]

    }

}
