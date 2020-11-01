package main.java.com.bobozhuang.reflection;

import java.lang.reflect.Field;

/**
 * description：     isPrimitive(判断是否是基本类型的字节码)
 *                  Filed类代表某一类中的一个成员变量。
 *
 * author Hubery
 * date 2020-10-13
 * version v0.0.1
 * since v0.0.1
 **/
public class ReflectionTest2 {

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        String str = "abc";
        Class cls1 = str.getClass();
        Class cls2 = String.class;
        Class cls3 = null;//必须要加上null
        try {
            cls3 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(cls1==cls2);
        System.out.println(cls1==cls3);

        System.out.println(cls1.isPrimitive());
        System.out.println(int.class.isPrimitive());//判定指定的 Class 对象是否表示一个基本类型。
        System.out.println(int.class == Integer.class);
        System.out.println(int.class == Integer.TYPE);
        System.out.println(int[].class.isPrimitive());
        System.out.println(int[].class.isArray());


        ReflectPointer rp1 = new ReflectPointer(3,4);
        Field fieldx = null;//必须是x或者y
        try {
            fieldx = rp1.getClass().getField("x");
            System.out.println(fieldx.get(rp1));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        /*
         * private的成员变量必须使用getDeclaredField，并setAccessible(true),否则看得到拿不到
         */
        try {
        Field fieldy = rp1.getClass().getDeclaredField("y");
        fieldy.setAccessible(true);//暴力反射
        System.out.println(fieldy.get(rp1));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
class ReflectPointer {

    public int x = 0;
    private int y = 0;

    public ReflectPointer(int x,int y) {//alt + shift +s相当于右键source
        super();
        // TODO Auto-generated constructor stub
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "ReflectPointer{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}