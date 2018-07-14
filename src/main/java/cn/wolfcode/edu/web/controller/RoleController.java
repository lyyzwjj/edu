package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Role;
import cn.wolfcode.edu.query.DepartmentQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IRoleService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping("")
    @RequiresPermissions("role:index")
    @PermissionName("角色首页")
    public String index() {
        return "role/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("role:list")
    @PermissionName("角色数据")
    public PageResult list(DepartmentQueryObject qo) {
        PageResult result = roleService.query(qo);
        return result;
    }

    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("role:save")
    @PermissionName("角色保存")
    public JsonResult save(Role role) {
        JsonResult result = new JsonResult();
        try {
            roleService.save(role);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    @RequiresPermissions("role:update")
    @PermissionName("角色更新")
    public JsonResult update(Role role) {
        JsonResult result = new JsonResult();
        try {
            roleService.update(role);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    @RequiresPermissions("role:delete")
    @PermissionName("角色删除")
    public JsonResult delete(Long id) {
        JsonResult result = new JsonResult();
        try {
            roleService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public List<Role> selectAll() {
        List<Role> roles = roleService.list();
        return roles;
    }

    @RequestMapping("getRoleIdByEmpId")
    @ResponseBody
    public List<Long> queryRoles(Long empId) {
        return roleService.getRoleIdByEmpId(empId);
    }


}
