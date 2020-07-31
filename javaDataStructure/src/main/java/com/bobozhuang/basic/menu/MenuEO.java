package main.java.com.bobozhuang.basic.menu;

import java.util.List;

/**
 * description：
 * author Hubery
 * date 2020-05-29
 * version v0.0.1
 * since v0.0.1
 **/
public class MenuEO {

    private int id;

    //菜单编码
    private String code;

    //菜单名
    private String name;

    //上级菜单编码
    private String parentCode;

    private List<MenuEO> childMenus;

    public MenuEO(int id, String code, String name, String parentCode, List<MenuEO> childMenus) {
        this.code = code;
        this.name = name;
        this.parentCode = parentCode;
        this.childMenus = childMenus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public List<MenuEO> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<MenuEO> childMenus) {
        this.childMenus = childMenus;
    }


    @Override
    public String toString() {
        return "MenuEO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", childMenus=" + childMenus +
                '}';
    }
}
