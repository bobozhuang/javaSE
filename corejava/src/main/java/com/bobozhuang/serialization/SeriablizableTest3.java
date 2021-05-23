package main.java.com.bobozhuang.serialization;

import java.io.*;

/**
 * description：
 * author Hubery
 * date 4:44 下午 2021/2/22
 * version v0.0.1
 * since v0.0.1
 **/
public class SeriablizableTest3 {

    public static void main(String[] args) {
        Userb user = new Userb();
        /** 对外引用其它对象，如果序列化该实例，则该对象实例也必须能实例化（implement Serializable） */
        Employee employee = new Employee(1, "Java programmer");

        user.setName("huberyHf");
        user.setId(1);
        user.setEmployee(employee);
        user.setPassword("aode2dt4");
        serializeUser(user);
        deserializeUser();
    }

    /**
     * 使用writeObject方法序列化
     *
     * @param user
     */
    private static void serializeUser(Userb user) {
        ObjectOutputStream outputStream = null;
        String path = "/Users/hubery/Code/bobozhuang/javaSE/corejava/src/main/java/com/bobozhuang/hubery/usera.txt";
        try {
            // 创建对象输出流, 包装一个其它类型目标输出流，如文件流
            outputStream = new ObjectOutputStream(new FileOutputStream(path));
            // 通过对象输出流的writeObject方法将对象user写入流中
            outputStream.writeObject(user);
            System.out.println("user序列化成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void deserializeUser() {
        Usera user = null;
        ObjectInputStream inputStream = null;
        String path = "/Users/hubery/Code/bobozhuang/javaSE/corejava/src/main/java/com/bobozhuang/hubery/usera.txt";
        try {
            // 创建对象输出流, 包装一个其它类型目标输出流，如文件流
            inputStream = new ObjectInputStream(new FileInputStream(path));
            // 通过对象输出流的writeObject方法将对象user写入流中
            user = (Usera) inputStream.readObject();
            // User静态变量初始化为0，不会被反序列化
            System.out.println("user反序列化成功！");
            System.out.println("id：" + user.getId());
            System.out.println("name：" + user.getName());
            System.out.println("count：" + user.getCount());
            System.out.println("password：" + user.getPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
