package main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus;

import main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus.interfaceLink.ICommOperate;

import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:
 * @date: 2019/5/12 17:27
 * @Package main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class DoubleCycleLinkList implements ICommOperate<DoubleLinkedNode> {
    private DoubleLinkedNode head = new DoubleLinkedNode("HEAD"); // 公共头指针，声明之后不变
    private int size = 0; // 记录链表节点数量

    public int getSize() {
        return this.size;
    }

    private void initLinkList() {
        if (size == 0) {
            this.head.setNextNode(this.head);
            this.head.setPriorNode(this.head);
        }
    }

    /*
     * 链表插入，每次往末端插入,判定末端的标准为next是否指向head
     * */
    @Override
    public boolean insertNode(DoubleLinkedNode node) {
        boolean flag = false;

        initLinkList(); // 初始化链表
        DoubleLinkedNode current = this.head;
        if (this.size == 0) {  // 空链表
            this.head.setNextNode(node);
            node.setPriorNode(this.head);
            node.setNextNode(this.head);
        } else {        // 链表内节点
            while (current.getNextNode() != this.head) { // 找到末端节点
                current = current.getNextNode();
            }
            current.setNextNode(node);
            node.setPriorNode(current);
            node.setNextNode(this.head); // 循坏链表，尾节点指向head
        }
        this.size++;
        flag = true;

        return flag;
    }

    /*
     * 插入链表指定位置pos,从1开始,而pos大于size则插入链表末端
     * */
    @Override
    public boolean insertPosNode(int pos, DoubleLinkedNode node) {
        boolean flag = true;

        initLinkList(); // 初始化链表
        DoubleLinkedNode current = this.head.getNextNode();
        if (this.size == 0) {           // 链表为空
            this.head.setNextNode(node);
            node.setPriorNode(this.head);
            node.setNextNode(this.head);
            this.size++;
        } else if (pos > this.size) {         // pos位置大于链表长度，插入末端
            insertNode(node);
        } else if (pos > 0 && pos <= this.size) {  // 链表内节点
            // 1、找到要插入位置pos节点,插入pos节点当前位置
            int find = 0;
            while (find < pos - 1 && current.getNextNode() != this.head) {
                current = current.getNextNode();
                find++;
            }
            // 2、插入节点
            if (current.getNextNode() == this.head) { // 尾节点
                node.setPriorNode(current);
                node.setNextNode(this.head);
                current.setNextNode(node);
            } else if (current.getNextNode() != this.head) { //中间节点
                node.setPriorNode(current.getPriorNode());
                node.setNextNode(current);
                current.getPriorNode().setNextNode(node);
                current.setPriorNode(node);
            }
            this.size++;
        } else {
            System.out.println("位置信息错误");
            flag = false;
        }
        return flag;
    }


    /*
     * 指定链表的节点pos，删除对应节点。方式：找到要删除节点的前后节点删除,下标从1开始
     * */
    @Override
    public boolean deleteNode(int pos) {
        boolean flag = false;
        DoubleLinkedNode current = this.head.getNextNode();
        if (pos <= 0 || pos > this.size || current == this.head) {
            System.out.println("位置信息错误或链表不存在");
        } else {
            // 1、找到要删除位置pos节点
            int find = 0;
            while (find < pos - 1 && current.getNextNode() != this.head) {
                current = current.getNextNode();
                find++;
            }
            // 2、删除节点
            if (current.getNextNode() == this.head) { // 尾节点
                current.getPriorNode().setNextNode(this.head);
            } else if (current.getNextNode() != this.head) { //中间节点
                current.getPriorNode().setNextNode(current.getNextNode());
                current.getNextNode().setPriorNode(current.getPriorNode());
            }
            System.gc(); // 回收删除节点
            this.size--;
            flag = true;
        }
        return flag;
    }

    /*
     * 指定链表的节点pos，修改对应节点,下标从1开始
     * */
    @Override
    public boolean updateNode(int pos, Map<String, Object> map) {
        boolean flag = false;
        DoubleLinkedNode node = getNode(pos, map);
        if (node != null) {
            String data = (String) map.get("data");
            node.setData(data);
            flag = true;
        }
        return flag;
    }

    /*
     * 找到指定链表的节点pos,下标从1开始
     * */
    @Override
    public DoubleLinkedNode getNode(int pos, Map<String, Object> map) {
        DoubleLinkedNode current = this.head.getNextNode();
        if (pos <= 0 || pos > this.size || current == this.head) {
            System.out.println("位置信息错误或链表不存在");
            return null;
        }
        int find = 0;
        while (find < pos - 1 && current != this.head) {
            current = current.getNextNode();
            find++;
        }
        return current;
    }

    /*
     * 打印链表
     * */
    @Override
    public void printLink() {
        int length = this.size;
        if (length == 0) {
            System.out.println("链表为空！");
            return;
        }
        DoubleLinkedNode current = this.head.getNextNode();
        int find = 0;
        System.out.println("总共有节点数: " + length + " 个");
        while (current != this.head) {
            System.out.println("第 " + (++find) + " 个节点 ：" + current);
            current = current.getNextNode();
        }
    }

    public static void main(String[] args) {
        DoubleCycleLinkList dcll = new DoubleCycleLinkList();
        DoubleLinkedNode node1 = new DoubleLinkedNode("节点1");
        DoubleLinkedNode node2 = new DoubleLinkedNode("节点2");
        DoubleLinkedNode node3 = new DoubleLinkedNode("节点3");
        DoubleLinkedNode node4 = new DoubleLinkedNode("节点4");
        DoubleLinkedNode node5 = new DoubleLinkedNode("节点5");
        DoubleLinkedNode node6 = new DoubleLinkedNode("插入指定位置");
        dcll.insertPosNode(10, node1);
        dcll.insertPosNode(10, node2);
        dcll.insertPosNode(8, node3);
        dcll.insertPosNode(88, node4);
        dcll.insertPosNode(8, node5);
//    dcll.insertNode(node1);
//    dcll.insertNode(node2);
//    dcll.insertNode(node3);
//    dcll.insertNode(node4);
//    dcll.insertNode(node5);

        System.out.println("*******************输出链表*******************");
        dcll.printLink();

        System.out.println("*******************获得指定链表节点*******************");
        int pos = 2;
        System.out.println("获取链表第 " + pos + "个位置数据 ：" + dcll.getNode(pos, null));

        System.out.println("*******************向链表指定位置插入节点*******************");
        int pos1 = dcll.getSize() + 1;
        System.out.println("将数据插入第" + pos1 + "个节点：");
        dcll.insertPosNode(pos1, node6);
        dcll.printLink();

        System.out.println("*******************删除链表指定位置节点*******************");
        int pos2 = 7;
        System.out.println("删除第" + pos2 + "个节点：");
        dcll.deleteNode(pos2);
        dcll.printLink();

        System.out.println("*******************修改链表指定位置节点*******************");
        int pos3 = 3;
        System.out.println("修改第" + pos3 + "个节点：");
        Map<String, Object> map = new HashMap<>();
        map.put("data", "this is a test");
        dcll.updateNode(pos3, map);
        dcll.printLink();
    }
}
