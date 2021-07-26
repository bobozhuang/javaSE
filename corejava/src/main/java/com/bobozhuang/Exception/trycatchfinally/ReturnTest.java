package main.java.com.bobozhuang.Exception.trycatchfinally;


import main.java.com.bobozhuang.collection.Student;

/**
 * description：在catch中有return,finally中无return的情况下,finally中的内容还是会执行，并且是先执行finally再return。
 *
 *      如果返回的是一个基本数据类型，则finally中的内容对返回的值没有影响。因为返回的是 finally执行之前生成的一个副本。
 *      如果是对象是会改变状态的。
 *
 *      当catch和finally都有return时，return的是finally的值。
 *
 * author Hubery
 * date 2020-04-21
 * version v0.0.1
 * since v0.0.1
 **/
public class ReturnTest {

    public static void main(String[] args) {
        System.out.println(two(2));
        System.out.println();
        System.out.println("----------three----------+");
        System.out.println(three(2));
        System.out.println();
        System.out.println("----------four----------");
        System.out.println(four(2));
        System.out.println();
        System.out.println("----------five----------");
        System.out.println(five(2));
        System.out.println("----------six----------");
        Student student = new Student(10,"jerry",true);
        System.out.println(six(student).toString());
        System.out.println("----------seven----------");
        Student student7 = new Student(10,"jerry",true);
        System.out.println(seven(student7).toString());
        System.out.println("----------eight----------");
        System.out.println(eight());
        System.out.println("----------nine----------");
        System.out.println(nine());
    }

    /**
     * 在catch中有return的情况下,finally中的内容还是会执行，并且是先执行finally再return。
     * @param i
     * @return
     */
    public static int two(int i) {
        try {
            throw new Exception("异常");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("return ~~");
            return i;
        } finally {
            System.out.println("finally ~~");

        }
    }

    /**
     * 当catch和finally都有return时，return的是finally的值。
     * @param i
     * @return
     */
    public static int three(int i) {
        try {
            throw new Exception("异常");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("return ~~");
            return i;
        } finally {
            System.out.println("finally ~~");
            return i + 2;
        }
    }

    /**
     * 这里是值传递，在执行return前，保留了一个i的副本，值为0，然后再去执行finally，finally完后，到return的时候，
     *  返回的并不是当前的i，而是保留的那个副本，也就是2.所以返回结果是2.
     * @param i
     * @return
     */
    public static int four(int i) {
        try {
            throw new Exception("异常");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("return ~~");
            return i;
        } finally {
            System.out.println("finally ~~");
            ++i;
            i=i+100;//还是 i
        }
    }

    /**
     * 都有 return 结果以finally这的代码逻辑为准
     * @param i
     * @return
     */
    public static int five(int i) {
        try {
            throw new Exception("异常");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("return ~~");
            return i;
        } finally {
            System.out.println("finally ~~");
            ++i;
            return i;
        }
    }

    /**
     * 引用传递的时候不管return的位置 finally 中的代码会生效
     * @param s
     * @return
     */
    public static Student six(Student s) {
        try {
            throw new Exception("异常");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("return ~~");
            return s;
        } finally {
            System.out.println("finally ~~");
            s.setId(1);
            return s;
        }
    }
    public static Student seven(Student s) {
        try {
            throw new Exception("异常");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("return ~~");
            return s;
        } finally {
            System.out.println("finally ~~");
            s.setId(1);//这个会修改掉

        }
    }

    public static String eight() {
        String str = "A";
        try {
            str = "B";
            return str;
        } finally {
            System.out.println("finally change return string to C");
            str = "C";
        }
    }

    public static String nine() {
        String str = "A";
        try {
            str = "B";
            return str;
        } finally {
            System.out.println("finally change return string to C");
            str = "C";
            return str;
        }
    }
}
