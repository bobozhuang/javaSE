package main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus;

import main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus.interfaceLink.LinkedNode;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:    双链表节点       priorNode: 优先的；在先的，在前的
 * @date: 2019/5/12 15:30
 * @Package main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class DoubleLinkedNode implements LinkedNode {
    private DoubleLinkedNode priorNode;
    private String data;
    private DoubleLinkedNode nextNode;

    public DoubleLinkedNode(){
    }
    public DoubleLinkedNode(String data) {
        this.priorNode = new DoubleLinkedNode() ;
        this.data = data ;
        this.nextNode = new DoubleLinkedNode() ;
    }

    public DoubleLinkedNode getPriorNode() {
        return priorNode;
    }
    public void setPriorNode(DoubleLinkedNode priorNode) {
        this.priorNode = priorNode;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public DoubleLinkedNode getNextNode() {
        return nextNode;
    }
    public void setNextNode(DoubleLinkedNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "DoubleLinkedNode [data=" + data + "]";
    }
}
