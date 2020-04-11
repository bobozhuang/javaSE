package main.java.com.bobozhuang.iolearn;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamTest {
    public static void main(String[] args) {

        String bbh = "/Users/hfhubery/Code/Git/bobozhuang/javaSE/corejava/src/main/java/com/bobozhuang/hubery/";

        //String s = new String("helloworld");
        Worker s = new Worker(10, "张三", true);

        ObjectOutputStream oos = null;
        try {
            File file = new File(bbh + "obj.txt");
            if (file.exists()) {
                boolean newFile = file.createNewFile();
                System.out.println(newFile);
            }
            oos = new ObjectOutputStream
                    (new FileOutputStream(file));
            oos.writeObject(s);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}




