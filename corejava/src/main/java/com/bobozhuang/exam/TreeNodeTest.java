package main.java.com.bobozhuang.exam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * description：
 * author Hubery
 * date 2021/6/26
 * version v0.0.1
 * since v0.0.1
 **/
public class TreeNodeTest {

    public static void main(String[] args) {



        TreeNode treeNode4 = new TreeNode("高架桥",4);
        Set<TreeNode> set3 = new HashSet<>();
        set3.add(treeNode4);

        TreeNode treeNode3 = new TreeNode("大桥",3);
        TreeNode treeNode6 = new TreeNode("高楼",6);
        treeNode3.setChildren(set3);
        Set<TreeNode> set2 = new HashSet<>();
        set2.add(treeNode3);
        set2.add(treeNode6);

        TreeNode treeNode2 = new TreeNode("建筑",2);
        treeNode2.setChildren(set2);
        Set<TreeNode> set1 = new HashSet<>();
        set1.add(treeNode2);

        TreeNode treeNode = new TreeNode();
        treeNode.setId(1);
        treeNode.setName("根");
        treeNode.setChildren(set1);

        System.out.println(treeNode.toString());

        System.out.println(getTreeNodeId(treeNode));
        System.out.println(getTreeNodeId(treeNode, 1));

    }

    /**
     * 获取知识树的指定节点，不实用递归的方式
     * 每次获取到子节点都放入集合A中下次循环集合A，循环中获取到节点值就结束循环，或者所有节点都没指定节点也结束循环
     * @param treeNodeRoot
     * @param id
     * @return
     */
    static List getTreeNodeId(TreeNode treeNodeRoot, Integer id){
        List nodeLists = new ArrayList<>();
        if (treeNodeRoot.getId() == id){
            nodeLists =getTreeNodeId(treeNodeRoot);
            return nodeLists;
        }
        TreeNode treeNodeResult = new TreeNode();
        Set<TreeNode> children = treeNodeRoot.getChildren();
        Set<TreeNode> childrens = new HashSet<>();

        boolean flag = false;

        while (0 != children.size() || !flag){
            for (TreeNode treeNode :
                    children) {
                if ( id == treeNode.getId()){
                    flag = true;
                    treeNodeResult = treeNode;
                    break;
                }else {
                    if (null != treeNode.getChildren()){
                        childrens.addAll(treeNode.getChildren());
                    }
                }
            }
            children.clear();
            children.addAll(childrens);
             childrens.clear();
        }

        nodeLists = getTreeNodeId(treeNodeResult);

        return nodeLists;
    }


    static List getTreeNodeId(TreeNode treeNodeRoot){
        ArrayList<Object> nodeLists = new ArrayList<>();

        Integer id = treeNodeRoot.getId();
        nodeLists.add(id);
        if (null != treeNodeRoot.getChildren()){
            for (TreeNode chilTreeNode :
                    treeNodeRoot.getChildren()) {
                System.out.println(chilTreeNode);
                List treeNodeId = getTreeNodeId(chilTreeNode);
                nodeLists.addAll(treeNodeId);

            }
        }

        return nodeLists;
    }


}
