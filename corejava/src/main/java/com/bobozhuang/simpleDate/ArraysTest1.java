package main.java.com.bobozhuang.simpleDate;

import java.util.Arrays;

/**
 * description： Java.util.Arrays工具类的使用.
 * <p>
 * 小点：对对象进行排序时，首先要实现comparable接口中的compareTo方法。
 * 才能对对象数组进行排序。
 * <p>
 * author Hubery
 * date 2020-09-23
 * version v0.0.1
 * since v0.0.1
 **/
public class ArraysTest1 {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
        int arr2[] = new int[]{1, 2, 3, 4, 5};
        int arr3[] = new int[]{1, 2, 3, 4, 5};
        // System.arraycopy()    把arr2复制到arr1的方法
        System.arraycopy(arr2, 2, arr1, 2, 3);
        // Arrays.toString()     把arr2数组的内容以string类型输出.
        System.out.println(Arrays.toString(arr1));
        // == ... 判断两数组的地址是否相同
        System.out.println(arr2 == arr3);//肯定不相等，因为是new出来的，会在堆内存从新开辟空间
        //Arrays.equals()...  判断两数组的内容是否相等.
        System.out.println(Arrays.equals(arr2, arr3));// 这个是通过遍历数组对没有个值进行比较
        //Arrays.copyOf()  返回值是一个数组 ,也是复制数组的方法,但是会返回一个新的数组,长度和要复制的长度一样
        int arr4[] = Arrays.copyOf(arr3, 10);
        System.out.println(Arrays.toString(arr4));
        //Arrays.fill()  填充数组,将数组中的每个元素都替换成输入的值.
        Arrays.fill(arr1, 99);
        System.out.println(Arrays.toString(arr1));
        //Arrays.sort  对数组排序-->升序
        int[] arr5 = {2, 5, 7, 1, 4};
        Arrays.sort(arr5);
        System.out.println(Arrays.toString(arr5));
        /**对对象进行排序
         * 1.首先让对象实现comparable的compareTo方法
         * 2.写出用那个属性进行排序
         * 3.排序.
         */
        Student[] stu = new Student[4];
        stu[0] = new Student(1, "小红", "女");
        stu[1] = new Student(4, "小兰", "女");
        stu[2] = new Student(7, "小吕", "男");
        stu[3] = new Student(2, "小嘿", "男");
        Arrays.sort(stu);
        for (Student s : stu) {
            System.out.println(s.toString());
        }
    }


}

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private String sex;

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;//这里使用id进行排序
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", sex=" + sex + "]";
    }

    public Student(int id, String name, String sex) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
}