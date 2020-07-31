package main.java.com.bobozhuang.basic.menu;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description：
 * author Hubery
 * date 2020-05-29
 * version v0.0.1
 * since v0.0.1
 **/
public class MenuBuild {

    public static void main(String[] args) {
        ArrayList<MenuEO> menuEOS = new ArrayList<>();
        menuEOS.add(new MenuEO(1,"M0001", "系统管理", null,null));
        menuEOS.add(new MenuEO(2,"M0002", "报表管理", null,null));
        menuEOS.add(new MenuEO(3,"M0001_01", "参数管理", "M0001",null));
        menuEOS.add(new MenuEO(4,"M0002_01", "财务管理", "M0002",null));
        menuEOS.add(new MenuEO(5,"M0002_02", "审计管理", "M0002",null));
        menuEOS.add(new MenuEO(6,"M0002_01_01", "年度财务报表", "M0002_01",null));
        menuEOS.add(new MenuEO(7,"M0002_01_02", "季度财务报表", "M0002_01",null));
        List build = buildMenu(menuEOS);

        System.out.println(build.toString());
    }

    public static List build(List<MenuEO> lm) {
        if (lm == null) {
            return null;
        }
        ArrayList<MenuEO> menuList = new ArrayList<>();
        for (MenuEO m :
                lm) {
            String parentCode = m.getParentCode();
            if (parentCode != null) {
                String mCode = m.getCode();

                for (MenuEO m1 :
                        lm) {
                    String pCode = m1.getParentCode();
                    ArrayList<MenuEO> childm = new ArrayList<>();
                    if (mCode == pCode){
                        childm.add(m1);
                        m.setChildMenus(childm);

                    }
                }
                menuList.add(m);
            }

        }

        return menuList;
    }

    public static List buildMenu(List<MenuEO> rootMenu){
        // 最后的结果
        List<MenuEO> menuList = new ArrayList<MenuEO>();
        // 先找到所有的一级菜单
        for (int i = 0; i < rootMenu.size(); i++) {
            // 一级菜单没有parentId
            if (rootMenu.get(i).getParentCode()== null) {
                menuList.add(rootMenu.get(i));
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (MenuEO menu : menuList) {
            menu.setChildMenus(getChild(menu.getCode(), rootMenu));
        }
        Map<String,Object> jsonMap = new HashMap<>();
        return menuList;
    }

    /**
     * 递归查找子菜单
     *
     * @param id
     *            当前菜单id
     * @param rootMenu
     *            要查找的列表
     * @return
     */
    private static List<MenuEO> getChild(String id, List<MenuEO> rootMenu) {
        // 子菜单
        List<MenuEO> childList = new ArrayList<>();
        for (MenuEO menu : rootMenu) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (null != menu.getParentCode()) {
                if (menu.getParentCode().equals(id)) {
                    childList.add(menu);
                }
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (MenuEO menu : childList) {// 没有url子菜单还有子菜单
            if (null != menu.getCode()) {
                // 递归
                menu.setChildMenus(getChild(menu.getCode(), rootMenu));
            }
        } // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }

}
