package main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus.interfaceLink;

import java.util.Map;

/**
 * @version V1.0
 * @author: Hubery
 * @Description: 接口操作类
 * @date: 2019/5/12 14:23
 * @Package main.java.com.bobozhuang.basic.chap05DataStructure.LinkPlus
 * @Copyright: 2019 www.bobozhuang.com Inc. All rights reserved. 注意：本内容仅限于Hubery内部传阅，禁止外泄以及用于其他的商业目的
 */
public interface ICommOperate<T> {

    /**
     * 链表插入，每次往末端插入
     *
     * @param node
     * @return
     */
    public boolean insertNode(T node);

    /**
     * 插入链表指定位置pos，从1开始,而pos大于size则插入链表末端
     * @param pos
     * @param node
     * @return
     */
    public boolean insertPosNode(int pos, T node);

    /**
     * 指定链表的节点pos，删除对应节点。方式：找到要删除节点的前后节点，进行删除。从1开始
     * @param pos
     * @return
     */
    public boolean deleteNode(int pos);

    /**
     * 指定链表的节点pos，修改对应节点。 从1开始
     * @param pos
     * @param map
     * @return
     */
    public boolean updateNode(int pos, Map<String, Object> map);

    /**
     * 找到指定链表的节点pos，从1开始
     * @param pos
     * @param map
     * @return
     */
    public T getNode(int pos, Map<String, Object> map);

    /**
     * 打印链表
     */
    public void printLink();



}
