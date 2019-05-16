package main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:
 * @date: 2019/5/12 14:31
 * @Package main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */

import main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus.interfaceLink.ICommOperate;

import java.util.HashMap;
import java.util.Map;

public class SingleLinkList implements ICommOperate<SingleLinkedNode> {

    private SingleLinkedNode head = new SingleLinkedNode("HEAD"); // 公共头指针，声明之后不变
    private int size = 0;

    public int getSize() {
        return this.size;
    }

    /*
     * 链表插入，每次往末端插入
     * */
    @Override
    public boolean insertNode(SingleLinkedNode node) {
        boolean flag = false;
        SingleLinkedNode current = this.head;
        if (this.size == 0) { // 空链表
            this.head.setNextNode(node);
            node.setNextNode(null);
        } else {
            // 链表内节点
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(node);
            node.setNextNode(null);
        }
        this.size++;
        flag = true;

        return flag;
    }

    /*
     * 插入链表指定位置pos，从1开始,而pos大于size则插入链表末端
     * */
    @Override
    public boolean insertPosNode(int pos, SingleLinkedNode node) {
        boolean flag = true;
        SingleLinkedNode current = this.head.getNextNode();

        if (this.size == 0) {          // 空链表
            this.head.setNextNode(node);
            node.setNextNode(null);
            this.size++;
        } else if (this.size < pos) {      // pos位置大于链表长度，插入末端
            insertNode(node);
        } else if (pos > 0 && pos <= this.size) { // 链表内节点
            // 1、找到要插入pos位置节点和前节点
            int find = 0;
            SingleLinkedNode preNode = this.head; // 前节点
            SingleLinkedNode currentNode = current; // 当前节点
            while (find < pos - 1 && currentNode.getNextNode() != null) {
                preNode = current;          // 前节点后移
                currentNode = currentNode.getNextNode(); // 当前节点后移
                find++;
            }
            //      System.out.println(preNode);
            //      System.out.println(currentNode);
            // 2、插入节点
            preNode.setNextNode(node);
            node.setNextNode(currentNode);
            this.size++;
            System.out.println("节点已经插入链表中");
        } else {
            System.out.println("位置信息错误");
            flag = false;
        }

        return flag;
    }
    /*
     * 指定链表的节点pos，删除对应节点。方式：找到要删除节点的前后节点，进行删除。从1开始
     * */

    @Override
    public boolean deleteNode(int pos) {
        boolean flag = false;
        SingleLinkedNode current = this.head.getNextNode();
        if (pos <= 0 || pos > this.size || current == null) {
            System.out.println("位置信息错误或链表无信息");
        } else {
            // 1、找到要删除节点的前后节点
            int find = 0;
            SingleLinkedNode preNode = this.head; // 前节点
            SingleLinkedNode nextNode = current.getNextNode(); // 后节点
            while (find < pos - 1 && nextNode.getNextNode() != null) {
                preNode = current;          // 前节点后移
                nextNode = nextNode.getNextNode(); // 后节点后移
                find++;
            }
            //      System.out.println(preNode);
            //      System.out.println(nextNode);
            // 2、删除节点
            preNode.setNextNode(nextNode);
            System.gc();
            this.size--;
            flag = true;
        }

        return flag;
    }

    /*
     * 指定链表的节点pos，修改对应节点。 从1开始
     * */
    @Override
    public boolean updateNode(int pos, Map<String, Object> map) {
        boolean flag = false;
        SingleLinkedNode node = getNode(pos, map); // 获得相应位置pos的节点
        if (node != null) {
            String data = (String) map.get("data");
            node.setData(data);
            flag = true;
        }
        return flag;
    }

    /*
     * 找到指定链表的节点pos，从1开始
     * */
    @Override
    public SingleLinkedNode getNode(int pos, Map<String, Object> map) {
        SingleLinkedNode current = this.head.getNextNode();
        if (pos <= 0 || pos > this.size || current == null) {
            System.out.println("位置信息错误或链表不存在");
            return null;
        }
        int find = 0;
        while (find < pos - 1 && current != null) {
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
        SingleLinkedNode current = this.head.getNextNode();
        int find = 0;
        System.out.println("总共有节点数: " + length + " 个");
        while (current != null) {
            System.out.println("第 " + (++find) + " 个节点 ：" + current);
            current = current.getNextNode();
        }
    }

    public static void main(String[] args) {
        SingleLinkList sll = new SingleLinkList();
        SingleLinkedNode node1 = new SingleLinkedNode("节点1");
        SingleLinkedNode node2 = new SingleLinkedNode("节点2");
        SingleLinkedNode node3 = new SingleLinkedNode("节点3");
        SingleLinkedNode node4 = new SingleLinkedNode("节点4");
        SingleLinkedNode node5 = new SingleLinkedNode("节点5");
        SingleLinkedNode node6 = new SingleLinkedNode("插入指定位置");
//        sll.insertPosNode(sll.getSize() + 1, node1);
//        sll.insertPosNode(sll.getSize() + 1, node2);
//        sll.insertPosNode(sll.getSize() + 1, node3);
//        sll.insertPosNode(sll.getSize() + 1, node4);
//        sll.insertPosNode(sll.getSize() + 1, node5);

        sll.insertNode(node1);
        sll.insertNode(node2);
        sll.insertNode(node3);
        sll.insertNode(node4);
        sll.insertNode(node5);

        System.out.println("*******************输出链表*******************");
        sll.printLink();

        System.out.println("*******************获得指定链表节点*******************");
        int pos = 2;
        System.out.println("获取链表第 " + pos + " 个位置数据 ：" + sll.getNode(pos, null));

        System.out.println("*******************向链表指定位置插入节点*******************");
        int pos1 = 2;
        System.out.println("将数据插入第 " + pos1 + " 个节点：");
        sll.insertPosNode(pos1, node6);
        sll.printLink();

        System.out.println("*******************删除链表指定位置节点*******************");
        int pos2 = 2;
        System.out.println("删除第 " + pos2 + " 个节点：");
        sll.deleteNode(pos2);
        sll.printLink();

        System.out.println("*******************修改链表指定位置节点*******************");
        int pos3 = 2;
        System.out.println("修改第 " + pos3 + " 个节点：");
        Map<String, Object> map = new HashMap<>();
        map.put("data", "this is a test");
        sll.updateNode(pos3, map);
        sll.printLink();
    }
}