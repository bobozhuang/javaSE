package main.java.com.bobozhuang.Exception.trycatchfinally;

/**
 * description：
 * author Hubery
 * date 2020-05-29
 * version v0.0.1
 * since v0.0.1
 **/
public class TryCatch {
    public static void main(String[] args){
        TryCatch c = new TryCatch();
        c.method();
    }
    public void method(){
        try{
            System.out.println("A");
            int i = 10 / 0;
            System.out.println("B");
        }catch(Exception e){
            System.out.println("C");
        }finally{
            System.out.println("D");
        }
    }
}

