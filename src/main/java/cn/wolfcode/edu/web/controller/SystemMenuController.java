package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Permission;
import cn.wolfcode.edu.domain.SystemMenu;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.ISystemMenuService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import cn.wolfcode.edu.util.SystemMenuUtil;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by WangZhe on 2018/7/12.
 */
@Controller
@RequestMapping("systemMenu")
public class SystemMenuController {
    @Autowired
    ISystemMenuService systemMenuService;

    @RequestMapping("")
    @RequiresPermissions("systemMenu:index")
    @PermissionName("菜单主页")
    public String index() {
        return "/systemMenu/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("systemMenu:list")
    @PermissionName("菜单数据")
    public PageResult list(QueryObject qo) {
        return systemMenuService.query(qo);
    }

    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("systemMenu:save")
    @PermissionName("菜单保存")
    public JsonResult save(SystemMenu systemMenu) {
        JsonResult result = new JsonResult();
        try {
            systemMenuService.save(systemMenu);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    @RequiresPermissions("systemMenu:delete")
    @PermissionName("菜单删除")
    public JsonResult delete(Long id) {
        JsonResult result = new JsonResult();
        try {
            systemMenuService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    @RequiresPermissions("systemMenu:update")
    @PermissionName("菜单更新")
    public JsonResult update(SystemMenu systemMenu) {
        JsonResult result = new JsonResult();
        try {
            systemMenuService.update(systemMenu);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("data")
    @RequiresPermissions("systemMenu:data")
    @PermissionName("主页菜单数据")
    public ModelAndView data(HttpServletResponse response) throws IOException {
        List<SystemMenu> list = systemMenuService.list();
        String jsonString = JSON.toJSONString(list);
        jsonString = jsonString.replace("\"parentId\":\"\",", "");
        jsonString = jsonString.replace("parentId", "_parentId");
        response.getWriter().write("{\"rows\":" + jsonString + "}");
        System.out.println(jsonString);
        return null;
    }

    @RequestMapping("queryRootMenu")
    @ResponseBody
    public List<SystemMenu> queryRootMenu() {
        return (List<SystemMenu>) SecurityUtils.getSubject().getSession().getAttribute(SystemMenuUtil.SYSTEM_MENU_IN_SESSION);
    }

    @ResponseBody
    @RequestMapping("queryAllParentSystemMenu")
    public List<SystemMenu> queryAllParentSystemMenu() {
        return systemMenuService.queryAllParentSystemMenu();
    }

    @ResponseBody
    @RequestMapping("queryIndexPermission")
    public List<Permission> queryIndexPermission() {
        return systemMenuService.queryIndexPermission();
    }
}
