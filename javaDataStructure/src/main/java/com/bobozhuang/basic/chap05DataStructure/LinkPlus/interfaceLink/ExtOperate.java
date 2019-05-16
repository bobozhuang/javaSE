package main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus.interfaceLink;

import main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus.SingleLinkedNode;

/**
 * @version V1.0
 * @author: Hubery
 * @Description:
 * @date: 2019/5/14 17:43
 * @Package main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public interface ExtOperate {

    /**
     * 判断单链表是否存在环
     * @param head
     * @return
     */
    public boolean isLoopList(LinkedNode head);
    /**
     * 找到有环链表的入口
     * @param head
     * @return
     */
    public LinkedNode findEntranceInLoopList(LinkedNode head);
}
