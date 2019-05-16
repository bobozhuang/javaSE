package main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus;

import main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus.interfaceLink.ExtOperate;
import main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus.interfaceLink.ICommOperate;
import main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus.interfaceLink.LinkedNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:
 * @date: 2019/5/12 16:25
 * @Package main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class SingleCycleLinkList implements ICommOperate<SingleLinkedNode>, ExtOperate {
    private SingleLinkedNode head = new SingleLinkedNode("HEAD"); // 公共头指针，声明之后不变
    private int size = 0;

    public int getSize() {
        return this.size;
    }

    private void initLinkList() {
        if (size == 0) {
            this.head.setNextNode(this.head);
        }
    }

    /*
     * 链表插入，每次往末端插入,判定末端的标准为next是否指向head
     * */
    @Override
    public boolean insertNode(SingleLinkedNode node) {
        boolean flag = false;

        initLinkList(); // 初始化链表
        if (this.size == 0) { // 空链表
            this.head.setNextNode(node);
            node.setNextNode(this.head);
        } else {
            SingleLinkedNode current = this.head;
            while (current.getNextNode() != this.head) { // 找到末端节点
                current = current.getNextNode();
            }
            current.setNextNode(node);
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
    public boolean insertPosNode(int pos, SingleLinkedNode node) {
        boolean flag = true;
        SingleLinkedNode current = this.head.getNextNode();

        initLinkList();// 初始化链表
        if (this.size == 0) {         // 链表为空
            this.head.setNextNode(node);
            node.setNextNode(this.head);// 循坏链表，尾节点指向head
            this.size++;
        } else if (this.size < pos) {      // pos位置大于链表长度，插入末端
            insertNode(node);
        } else if (pos > 0 && pos <= this.size) { // 链表内节点
            // 1、找到要插入pos位置节点和前节点，node将插入两个节点之间
            int find = 0;
            SingleLinkedNode preNode = this.head; // 前节点
            SingleLinkedNode currentNode = current; // 当前节点
            while (find < pos - 1 && currentNode != this.head) {
                preNode = current;             // 前节点后移
                currentNode = currentNode.getNextNode(); // 当前节点后移
                find++;
                if (find < pos - 1 && currentNode != this.head) { // 未结束寻找节点前，后移前节点
                    current = current.getNextNode();
                }
            }
//      System.out.println(preNode);
//      System.out.println(currentNode);

            // 2、插入节点
            preNode.setNextNode(node);
            node.setNextNode(currentNode);
            this.size++;
        } else {
            System.out.println("位置信息错误");
            flag = false;
        }

        return flag;
    }


    /*
     * 指定链表的节点pos，删除对应节点。方式：找到要删除节点的前后节点,进行删除,下标从1开始
     * */
    @Override
    public boolean deleteNode(int pos) {
        boolean flag = false;
        SingleLinkedNode current = this.head.getNextNode();
        if (pos <= 0 || pos > this.size || current == this.head) {
            System.out.println("位置信息错误或链表无信息");
        } else {
            // 1、找到要删除节点的前后节点
            int find = 0;
            SingleLinkedNode preNode = this.head; // 前节点
            SingleLinkedNode nextNode = current.getNextNode(); // 后节点
            while (find < pos - 1 && nextNode != this.head) {
                preNode = current;          // 前节点后移
                nextNode = nextNode.getNextNode(); // 后节点后移
                find++;
                if (find < pos - 1 && nextNode != this.head) { // 未结束找节点前，后移"前节点"
                    current = current.getNextNode();
                }
            }
//      System.out.println(preNode);
//      System.out.println(nextNode);

            // 2、删除节点
            preNode.setNextNode(nextNode);
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
        SingleLinkedNode node = getNode(pos, map); // 获得相应位置pos的节点
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
    public SingleLinkedNode getNode(int pos, Map<String, Object> map) {
        SingleLinkedNode current = this.head.getNextNode();
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
        SingleLinkedNode current = this.head.getNextNode();
        System.out.println("总共有节点数: " + length + " 个");
        int find = 0;
        while (current != this.head) {
            System.out.println("第 " + (++find) + " 个节点 ：" + current);
            current = current.getNextNode();
        }
    }
    @Override
    public boolean isLoopList(LinkedNode head) {
        SingleLinkedNode slowPointer, fastPointer;

        //使用快慢指针，慢指针每次向前一步，快指针每次两步
        slowPointer = fastPointer = (SingleLinkedNode) head;
        while (fastPointer != null && fastPointer.nextNode != null) {
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;
            //两指针相遇则有环
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

    @Override
    public LinkedNode findEntranceInLoopList(LinkedNode head) {
        LinkedNode slowPointer, fastPointer;

        //使用快慢指针，慢指针每次向前一步，快指针每次两步
        boolean isLoop = false;
        slowPointer = fastPointer = head;
        while (fastPointer != null && fastPointer.nextNode != null) {
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;

            //两指针相遇则有环
            if (slowPointer == fastPointer) {
                isLoop = true;
                break;
            }
        }

        //一个指针从链表头开始，一个从相遇点开始，每次一步，再次相遇的点即是入口节点
        if (isLoop) {
            slowPointer = head;
            while (fastPointer != null && fastPointer.nextNode != null) {
                //两指针相遇的点即是入口节点
                if (slowPointer == fastPointer) {
                    return slowPointer;
                }

                slowPointer = slowPointer.nextNode;
                fastPointer = fastPointer.nextNode;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SingleCycleLinkList scll = new SingleCycleLinkList();
        SingleLinkedNode node1 = new SingleLinkedNode("节点1");
        SingleLinkedNode node2 = new SingleLinkedNode("节点2");
        SingleLinkedNode node3 = new SingleLinkedNode("节点3");
        SingleLinkedNode node4 = new SingleLinkedNode("节点4");
        SingleLinkedNode node5 = new SingleLinkedNode("节点5");
        SingleLinkedNode node6 = new SingleLinkedNode("插入指定位置");
//    scll.insertPoSingleLinkedNode(scll.getSize()+1, node1) ;
//    scll.insertPoSingleLinkedNode(scll.getSize()+1, node2) ;
//    scll.insertPoSingleLinkedNode(scll.getSize()+1, node3) ;
//    scll.insertPoSingleLinkedNode(scll.getSize()+1, node4) ;
//    scll.insertPoSingleLinkedNode(scll.getSize()+1, node5) ;
        scll.insertNode(node1);
        scll.insertNode(node2);
        scll.insertNode(node3);
        scll.insertNode(node4);
        scll.insertNode(node5);

        System.out.println("*******************输出链表*******************");
        scll.printLink();

        System.out.println("*******************获得指定链表节点*******************");
        int pos = 2;
        System.out.println("获取链表第 " + pos + " 个位置数据 ：" + scll.getNode(pos, null));

        System.out.println("*******************向链表指定位置插入节点*******************");
        int pos1 = 3;
        System.out.println("将数据插入第" + pos1 + "个节点：");
        scll.insertPosNode(pos1, node6);
        scll.printLink();

        System.out.println("*******************删除链表指定位置节点*******************");
        int pos2 = 3;
        System.out.println("删除第" + pos2 + "个节点：");
        scll.deleteNode(pos2);
        scll.printLink();

        System.out.println("*******************修改链表指定位置节点*******************");
        int pos3 = 3;
        System.out.println("修改第" + pos3 + "个节点：");
        Map<String, Object> map = new HashMap<>();
        map.put("data", "this is a test");
        scll.updateNode(pos3, map);
        scll.printLink();
    }

}

