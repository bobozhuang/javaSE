package main.java.com.bobozhuang.iolearn.file;

import org.junit.Test;

/**
 * description：
 * author Hubery
 * date 6:26 下午 2021/2/18
 * version v0.0.1
 * since v0.0.1
 **/
public class GetClassPath {

    public static void main(String[] args) {

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        String path2 = "";
        if (contextClassLoader != null){

            //path2 = contextClassLoader.getResource("/").getPath();
        }


        System.out.printf("-------");
        System.out.printf("path1: " + path2 != null ? path2 : "");
        String s = Test.class.getResource("/").toString();
        System.out.printf("-------");
        System.out.printf("path2: " + s != null ? s : "");
    }
}
