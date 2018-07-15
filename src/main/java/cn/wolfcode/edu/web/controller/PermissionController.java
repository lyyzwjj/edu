package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Department;
import cn.wolfcode.edu.domain.Permission;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IPermissionService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;
    @RequestMapping("")
    @RequiresPermissions("permission:index")
    @PermissionName("权限首页")
    public String index(){
        return "permission/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("permission:list")
    @PermissionName("权限数据")
    public PageResult list(QueryObject qo){
        return permissionService.query(qo);
    }

    @RequestMapping("all")
    @ResponseBody
    public List<Permission> all(){

        return permissionService.list();
    }


    @RequestMapping("reload")
    @ResponseBody
    @RequiresPermissions("permission:reload")
    @PermissionName("权限加载")
    public JsonResult save(Department permission){
       JsonResult result=new JsonResult();
        try {
            permissionService.reload();
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("加载失败!");
        }
        return result;
    }
    @RequestMapping("queryPermissionByRoleId")
    @ResponseBody
    public List<Permission> queryPermissionByRoleId(Long roleId){

        return permissionService.queryPermissionByRoleId(roleId);
    }
}
