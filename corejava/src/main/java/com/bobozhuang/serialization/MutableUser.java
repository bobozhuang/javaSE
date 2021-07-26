package main.java.com.bobozhuang.serialization;

import java.io.*;
import java.util.Date;

/**
 * description：
 * author Hubery
 * date 5:12 下午 2021/2/22
 * version v0.0.1
 * since v0.0.1
 **/
public class MutableUser {
    public Userc user;
    private String name;
    public Date birthday;

    //这个构造函数的意思是通过反序列化来创建出对象
    public MutableUser(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            // 字节流有效的User实例开头，然后附加额外的引用
            out.writeObject(new Userc(new Date()));
            // 假设这是恶意的二进制，即附加恶意对象引用Date
            byte[] ref = {0x71, 0, 0x7e, 0 ,5};
            //bos.write(ref);
            byte[] bytes = bos.toByteArray();

            // 攻击者从ObjectInputStream中读取User实例，然后读取附加在后面的“恶意编制对象引用Date”
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes));
            user = (Userc) in.readObject();
            birthday = (Date) in.readObject();

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        MutableUser mutableUser = new MutableUser();
        Userc user = mutableUser.user;
        Date birthday = mutableUser.birthday;
        // 攻击者修改User内部birthday私有域，年份更改为2018 这个地方代表将反序列化的结果修改
        birthday.setTime(2018);
        System.out.println(user);
    }

    private void readObject(ObjectInputStream inputStream)
            throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        // 保护性拷贝birthday
        birthday = new Date(birthday.getTime());
        // 约束条件name不能为null
        if (name == null || name != "") {
            throw new NullPointerException("name is null");
        }
    }
}
