package main.java.com.bobozhuang.basic.chap03MethodCite;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:    将 System.out::println 方法作为静态方法来引用。
 * @date: 2019/4/23 15:41
 * @Package main.java.com.bobozhuang.basic.chap03MethodCite
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class TesterA {

    public static void main(String args[]){
        List names = new ArrayList();

        names.add("Google");
        names.add("Hubery");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }

}
