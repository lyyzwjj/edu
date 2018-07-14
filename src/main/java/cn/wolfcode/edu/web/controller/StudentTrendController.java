package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.StudentTrend;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.StudentTrendQueryObject;
import cn.wolfcode.edu.service.IStudentTrendService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("studentTrend")
public class StudentTrendController {

    @Autowired
    private IStudentTrendService studentTrendService;
    @RequestMapping("")
    @PermissionName("学员转换首页")
    public String index(){
        return "studentTrend/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("studentTrend:list")
    @PermissionName("学员转换数据")
    public PageResult list(StudentTrendQueryObject qo){
        return studentTrendService.query(qo);
    }

    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("studentTrend:save")
    @PermissionName("学员转换保存")
    public JsonResult save(StudentTrend studentTrend){
       JsonResult result=new JsonResult();
        try {
            studentTrendService.save(studentTrend);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存操作失败!");
        }
        return result;
    }
    @RequestMapping("update")
    @ResponseBody
    @RequiresPermissions("studentTrend:update")
    @PermissionName("学员转换更新")
    public JsonResult update(StudentTrend studentTrend){
        JsonResult result=new JsonResult();
        try {
            studentTrendService.update(studentTrend);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("编辑操作失败!");
        }
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    @RequiresPermissions("studentTrend:delete")
    @PermissionName("学员转换删除")
    public JsonResult delete(Long id){
        JsonResult result=new JsonResult();
        try {
            studentTrendService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("编辑操作失败!");
        }
        return result;
    }

    @RequestMapping("changeState")
    @ResponseBody
    public JsonResult changeState(Long id,int stateId) {
        JsonResult result = new JsonResult();
        try {
            studentTrendService.changeState(id,stateId);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("审核失败");
        }
        return result;
    }
}
