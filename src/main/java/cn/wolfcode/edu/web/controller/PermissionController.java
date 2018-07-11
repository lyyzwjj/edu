package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Department;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IPermissionService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;
    @RequestMapping("")
    @PermissionName("员工列表")
    public String index(){
        return "permission/list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageResult list(QueryObject qo){
        return permissionService.query(qo);
    }

    @RequestMapping("reload")
    @ResponseBody
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

}
