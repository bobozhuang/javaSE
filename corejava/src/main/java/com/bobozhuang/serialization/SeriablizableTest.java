package main.java.com.bobozhuang.serialization;

import java.io.*;

/**
 * description：
 * author Hubery
 * date 6:15 下午 2021/2/18
 * version v0.0.1
 * since v0.0.1
 **/
public class SeriablizableTest {

    public static void main(String[] args) {
        User user = new User(1, "lijian");
        serializeUser(user);
        deserializeUser();

    }

    /**
     * 使用writeObject方法序列化
     * @param user
     */
    private static void serializeUser(User user) {
        ObjectOutputStream outputStream = null;
        try {
            // 创建对象输出流, 包装一个其它类型目标输出流，如文件流
            outputStream = new ObjectOutputStream(new FileOutputStream("D:\\user.txt"));
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
        User user = null;
        Employee employee = null;
        ObjectInputStream inputStream = null;
        try {
            // 创建对象输出流, 包装一个其它类型目标输出流，如文件流
            inputStream = new ObjectInputStream(new FileInputStream("D:\\user.txt"));
            // 通过对象输出流的writeObject方法将对象user写入流中
            user = (User)inputStream.readObject();
            System.out.println("user反序列化成功：" + user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }
        finally {
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
