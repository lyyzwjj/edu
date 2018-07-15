package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.StudentLeave;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.StudentLeaveQueryObject;
import cn.wolfcode.edu.query.StudentQueryObject;
import cn.wolfcode.edu.service.IStudentLeaveService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("studentLeave")
public class StudentLeaveController {

    @Autowired
    private IStudentLeaveService studentLeaveService;
    @RequestMapping("")
    @RequiresPermissions("studentLeave:")
    @PermissionName("学员流失首页")
    public String index(){
        return "studentLeave/listindex";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("studentLeave:list")
    @PermissionName("学员流失数据")
    public PageResult list(StudentLeaveQueryObject qo){
        return studentLeaveService.query(qo);
    }

    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("studentLeave:save")
    @PermissionName("学员流失保存")
    public JsonResult save(StudentLeave studentLeave){
       JsonResult result=new JsonResult();
        try {
            studentLeaveService.save(studentLeave);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存操作失败!");
        }
        return result;
    }
    @RequestMapping("update")
    @ResponseBody
    @RequiresPermissions("studentLeave:update")
    @PermissionName("学员流失更新")
    public JsonResult update(StudentLeave studentLeave){
        System.out.println("============1");
        JsonResult result=new JsonResult();
        try {
            studentLeaveService.update(studentLeave);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("编辑操作失败!");
        }
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    @RequiresPermissions("studentLeave:delete")
    @PermissionName("学员流失删除")
    public JsonResult delete(Long id){
        JsonResult result=new JsonResult();
        try {
            studentLeaveService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("编辑操作失败!");
        }
        return result;
    }
    @RequestMapping("changeState")
    @ResponseBody
    @RequiresPermissions("studentLeave:changeState")
    @PermissionName("学员流失状态更新")
    public JsonResult changeState(Long id){
        JsonResult result=new JsonResult();
        try {
            studentLeaveService.changeState(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("改变状态失败!");
        }
        return result;
    }
}
