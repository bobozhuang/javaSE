package main.java.com.bobozhuang.basic.chap05DataStructure.Link;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:
 * @date: 2019/5/8 18:02
 * @Package main.java.com.bobozhuang.basic.chap05DataStructure.Link
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */

public class StackSingleLink {
    private SingleLinkedList link;

    public StackSingleLink(){
        link = new SingleLinkedList();
    }

    //添加元素
    public void push(Object obj){
        link.addHead(obj);
    }

    //移除栈顶元素
    public Object pop(){
        Object obj = link.deleteHead();
        return obj;
    }

    //判断是否为空
    public boolean isEmpty(){
        return link.isEmpty();
    }

    //打印栈内元素信息
    public void display(){
        link.display();
    }

}
