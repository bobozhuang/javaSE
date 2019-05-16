package main.java.com.bobozhuang.basic.chap04Functional;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:
 * @date: 2019/4/28 19:31
 * @Package main.java.com.bobozhuang.basic.chap04Functional
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class GreetingServiceA {
    @FunctionalInterface
    interface GreetingService {
        void sayMessage(String message);

        default void doSomeMoreWork1() {
            // Method body
            int a = 3;
        }

        default void doSomeMoreWork2() {
            // Method body
        }

        static void printHello() {
            System.out.println("good!");
        }

        @Override
        boolean equals(Object obj);
    }
}
