package main.java.com.bobozhuang.day02;

/**
 * description：     Java 开发设计者在对数组的复制时，通常都会使用 System.arraycopy() 方法。
 *                      比如ArrayList的实现
 *                      但是需要注意的是System.arraycopy()是浅复制
 *
 *                      public static void arraycopy(
 *                      Object src, //源数组
 *                      int srcPos, //源数组的起始位置
 *                      Object dest, //目标数组
 *                      int destPos, //目标数组的起始位置
 *                      int length //复制长度
 *                      )
 *
 *
 * author Hubery
 * date 2020-12-06
 * version v0.0.1
 * since v0.0.1
 **/
public class ArrayTest3 {

    public static void main(String[] args) {
        User[] users = new User[]{
                new User(1, "seven", "seven@qq.com"),
                new User(2, "six", "six@qq.com"),
                new User(3, "ben", "ben@qq.com")};// 初始化对象数组

        User[] target = new User[users.length];// 新建一个目标对象数组

        System.arraycopy(users, 0, target, 0, users.length);// 实现复制

        System.out.println("源对象与目标对象的物理地址是否一样：" + (users[0] == target[0] ? "浅复制" : "深复制"));  //浅复制

        target[0].setEmail("admin@sina.com");

        System.out.println("修改目标对象的属性值后源对象users：");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
