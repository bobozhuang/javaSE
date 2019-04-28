package main.java.com.bobozhuang.basic.chap04Functional;

/**
 * @version V1.0
 * @author: Hubery
 * @Description: 函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 * 函数式接口可以被隐式转换为 lambda 表达式。
 * Lambda 表达式和方法引用（实际上也可认为是Lambda表达式）上。
 * @date: 2019/4/24 21:13
 * @Package main.java.com.bobozhuang.basic.chap04Functional
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
@FunctionalInterface
interface GreetingService
{
    void sayMessage(String message);
}
