package main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus;

import main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus.interfaceLink.LinkedNode;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:    单连表节点
 * @date: 2019/5/12 14:25
 * @Package main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class SingleLinkedNode implements LinkedNode {
    public static String data;
    public static SingleLinkedNode nextNode;
    public SingleLinkedNode() {
    }
    public SingleLinkedNode(String data) {
        this.data = data;
        this.nextNode = new SingleLinkedNode();
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public SingleLinkedNode getNextNode() {
        return nextNode;
    }
    public void setNextNode(SingleLinkedNode nextNode) {
        this.nextNode = nextNode;
    }
    @Override
    public String toString() {
        return "SingleLinkedNode [data=" + data + "]";
    }
}
