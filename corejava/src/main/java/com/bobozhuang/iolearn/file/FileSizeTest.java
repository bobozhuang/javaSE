package main.java.com.bobozhuang.iolearn.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * description：     File的length()方法返回的类型为long，long型能表示的正数最大值为：9223372036854775807，折算成最大能支持的文件大小为：8954730132868714 EB字节，
 * 而FileInputStream的avaliable()方法返回值是int，最大的表示范围Integer.MAX_VALUE=2147483647，所能支持的最大文件大小为：1.99GB，而这个量级很容易就达到了。
 * FileChannel得到的结果与第一种情况吻合，准确地描述了文件的准确大小
 * author Hubery
 * date 2020-04-30
 * version v0.0.1
 * since v0.0.1
 **/
public class FileSizeTest {

    public static void main(String[] args) {

        String bbh = "/Users/hfhubery/Code/Git/bobozhuang/javaSE/corejava/src/main/java/com/bobozhuang/hubery/";
        File f = new File(bbh + "favicon.ico");

        /*  functionone */
        if (f.exists() && f.isFile()){
            System.out.println(f.length());
        }else{
            System.out.println("file doesn't exist or is not a file");
        }

        /*  functiontwo */
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
            System.out.println(fis.available());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fis) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /*  functionthree  */
        FileChannel fc= null;
        try {
            if (f.exists() && f.isFile()){
                FileInputStream fist= new FileInputStream(f);
                fc= fist.getChannel();
                System.out.println(fc.size());
            }else{
                System.out.println("file doesn't exist or is not a file");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null!=fc){
                try{
                    fc.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }




    }
}
