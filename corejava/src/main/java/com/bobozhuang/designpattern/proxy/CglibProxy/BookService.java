package main.java.com.bobozhuang.designpattern.proxy.CglibProxy;

/**
 * description： 重点是这个被代理的类没有实现接口，所以通过cglib的Code生成类库
 *  可以在运行期扩展Java类与实现Java接口
 * author Hubery
 * date 2020-08-19
 * version v0.0.1
 * since v0.0.1
 **/
public class BookService {

    public void addBook() {
        System.out.println("添加书籍成功");
    }

}
