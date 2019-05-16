package main.java.com.bobozhuang.basic.chap05DataStructure.Issue;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:        题目：一群人围在一起丢手绢，开始指定从第m个人开始，然后瞬时针数k下，第k个人出列，剩下的人继续
 *                          从0开始数到k，第k个人再次出列，问，最后一个人是谁？
 * @date: 2019/5/12 17:39
 * @Package main.java.com.bobozhuang.basic.chap05DataStructure.Issue
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class CycLink {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Link cyc = new Link();
        cyc.setLen(5);
        cyc.createLink();
        cyc.setK(2);
        cyc.setM(2);
        cyc.print();
        cyc.play();
    }

}

//创建一个节点类
class Node {
    //编号
    public int num;
    //保存下一个节点
    Node next;

    //默认构造函数
    public Node() {
    }

    //构造函数
    public Node(int num) {
        this.num = num;
    }
}

//创建一个循环链表
class Link {
    //保存链表的长度
    public int len = 0;
    //保存游戏从第k个人开始
    public int k = 0;
    //保存游戏数多少下
    public int m = 0;
    //设置一个头节点
    Node head = new Node(0);
    //设置一个临时节点
    Node temp = null;

    //设置链表长度
    public void setLen(int len) {
        this.len = len;
    }

    //设置k的值
    public void setK(int k) {
        this.k = k;
    }

    //m
    public void setM(int m) {
        this.m = m;
    }

    //生成循环链表
    public void createLink() {
        for (int i = 1; i <= len; i++) {
            if (i == 1) {
                Node node = new Node(i);
                head.next = node;
                temp = node;
            } else if (i < len) {
                Node node = new Node(i);
                temp.next = node;
                temp = node;
            } else {
                Node node = new Node(i);
                temp.next = node;
                node.next = head;
            }
        }
    }

    //开始玩游戏
    public void play() {
        //临时节点置空
        temp = null;
        //用temp1存放temp之前一个节点
        Node temp1 = null;
        temp = head.next;
        temp1 = head;
        //找到第k个人的位置
        for (int i = 1; i < k; i++) {
            temp = temp.next;
            temp1 = temp1.next;
        }
        //数多少下
        while (len == 1) {
            for (int j = 1; j < m; j++) {
                temp = temp.next;
                temp1 = temp1.next;
            }
            //删除temp节点
            temp1.next = temp.next;
            //链表长度减1
            len--;
        }
        //输出结果
        System.out.println("\n" + "最后一个数为：" + temp.num);


    }

    //输出循环链表
    public void print() {
        temp = null;
        temp = head.next;
        while (temp != head) {
            //输出该节点的编号
            System.out.print(temp.num + "\t");
            temp = temp.next;
        }

    }
}
