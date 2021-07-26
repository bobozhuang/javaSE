package main.java.com.bobozhuang.exam;

import java.util.Set;

/**
 * description：
 * author Hubery
 * date 2021/6/26
 * version v0.0.1
 * since v0.0.1
 **/
public class TreeNode {

    String name;
    Integer id;
    Set<TreeNode> children;

    public TreeNode() {
    }

    public TreeNode(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(Set children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", children=" + children +
                '}';
    }
}
