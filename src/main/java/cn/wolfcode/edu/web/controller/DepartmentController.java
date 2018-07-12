package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Department;
import cn.wolfcode.edu.query.DepartmentQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IDepartmentService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;
    @RequestMapping("")
    @PermissionName("部门列表")
    public String index(){
        return "department/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("department:list")
    @PermissionName("部门数据")
    public PageResult list(DepartmentQueryObject qo){
        return departmentService.query(qo);
    }

    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("department:save")
    @PermissionName("保存部门")
    public JsonResult save(Department department){
       JsonResult result=new JsonResult();
        try {
            departmentService.save(department);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存操作失败!");
        }
        return result;
    }
    @RequestMapping("update")
    @ResponseBody
    @RequiresPermissions("department:update")
    @PermissionName("更新部门")
    public JsonResult update(Department department){
        JsonResult result=new JsonResult();
        try {
            departmentService.update(department);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("编辑操作失败!");
        }
        return result;
    }
    @RequestMapping("changeState")
    @ResponseBody
    @RequiresPermissions("department:changeState")
    @PermissionName("更新部门状态")
    public JsonResult changeState(Long id){
        JsonResult result=new JsonResult();
        try {
            departmentService.changeState(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("改变状态失败!");
        }
        return result;
    }

    @RequestMapping("queryDepts")
    @ResponseBody
    public List<Department> queryDepts() {
        List<Department> departments = departmentService.list();
        return departments;
    }
}
