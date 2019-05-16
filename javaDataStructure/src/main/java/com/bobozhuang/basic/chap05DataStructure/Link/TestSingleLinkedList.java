package main.java.com.bobozhuang.basic.chap05DataStructure.Link;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:
 * @date: 2019/5/8 17:12
 * @Package main.java.com.bobozhuang.basic.chap05DataStructure.Link
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public class TestSingleLinkedList {
    public void testSingleLinkedList(){
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.addHead("A");
        singleList.addHead("B");
        singleList.addHead("C");
        singleList.addHead("D");
        //打印当前链表信息
        singleList.display();
        //删除C
        singleList.delete("C");
        singleList.display();
        //查找B
        System.out.println(singleList.find("B"));
    }

}
