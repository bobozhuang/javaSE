package main.java.com.bobozhuang.basic.chap05interfaceDefault;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:
 * @date: 2019/4/28 20:04
 * @Package main.java.com.bobozhuang.basic.chap05interfaceDefault
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public interface FourWheeler {

    default void print(){
        System.out.println("我是一辆四轮车!");
    }

}
