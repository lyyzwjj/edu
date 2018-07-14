package cn.wolfcode.edu.util;

import cn.wolfcode.edu.domain.Permission;
import cn.wolfcode.edu.domain.SystemMenu;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.util.Iterator;
import java.util.List;

/**
 * Created by WangZhe on 2018/7/14.
 */
public class SystemMenuUtil {
    public static final String SYSTEM_MENU_IN_SESSION = "system_menu_in_session";
    public static void filterSystemMenu(List<SystemMenu> menus) {
        Subject subject = SecurityUtils.getSubject();
        Iterator<SystemMenu> iter = menus.iterator();
        while (iter.hasNext()) {
            SystemMenu menu = iter.next();
            Permission permission = menu.getPermission();
            if (permission != null) {
                if (!subject.isPermitted(permission.getResource())) {
                    iter.remove();
                }
            }
            List<SystemMenu> children = menu.getChildren();
            while (children != null && children.size() > 0) ;
            filterSystemMenu(children);
        }
    }
    //优化, 删除过滤菜单之后存在无儿子的父菜单
    public static void filterMenu(List<SystemMenu> menus) {
        //过滤菜单
        filterSystemMenu(menus);

        //删除无儿子的父菜单(空菜单)
        Iterator<SystemMenu> iter = menus.iterator();
        while (iter.hasNext()){
            SystemMenu menu = iter.next();
            if(menu.getChildren() == null || menu.getChildren().size() == 0){
                iter.remove();
            }
        }
    }
}
