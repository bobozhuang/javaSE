package main.java.com.bobozhuang.designpattern.proxy.CglibProxy;

/**
 * description：
 * author Hubery
 * date 2020-08-19
 * version v0.0.1
 * since v0.0.1
 **/
public class TestCglibProxy {

    public static void main(String[] args) {
        MyCglibProxyFactory cglib = new MyCglibProxyFactory();
        BookService bookCglib =
                (BookService) cglib.getInstance(new BookService().getClass());

        bookCglib.addBook();
        System.out.println(bookCglib.getClass());
    }

}
