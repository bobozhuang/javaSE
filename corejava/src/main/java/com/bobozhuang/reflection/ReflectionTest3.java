package main.java.com.bobozhuang.reflection;

import java.lang.reflect.Field;

/**
 * description：     将所有String类型成员变量的value包含b的改成a。
 * author Hubery
 * date 2020-10-13
 * version v0.0.1
 * since v0.0.1
 **/
public class ReflectionTest3 {

    public static void main(String[] args) throws SecurityException, NoSuchMethodException, NoSuchFieldException, IllegalArgumentException, Exception {
        ReflectPointer3 rp1 = new ReflectPointer3(3,4);
        changeBtoA(rp1);
        System.out.println(rp1);

    }

    private static void changeBtoA(Object obj) throws RuntimeException, Exception {
        Field[] fields = obj.getClass().getFields();

        for(Field field : fields) {
            //if(field.getType().equals(String.class))
            //由于字节码只有一份,用equals语义不准确
            if(field.getType()==String.class) {
                String oldValue = (String)field.get(obj);
                System.out.println("oldValue:" + oldValue);
                String newValue = oldValue.replace('b', 'a');
                field.set(obj,newValue);
            }
        }
    }
}
class ReflectPointer3 {

    private int x = 0;
    public int y = 0;
    public String str1 = "ball";
    public String str2 = "basketball";
    public String str3 = "itcat";

    public ReflectPointer3(int x,int y) {//alt + shift +s相当于右键source
        super();
        // TODO Auto-generated constructor stub
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "ReflectPointer [str1=" + str1 + ", str2=" + str2 + ", str3="
                + str3 + "]";
    }
}