package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Grade;
import cn.wolfcode.edu.query.GradeQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IGradeService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("grade")
public class GradeController {

    @Autowired
    private IGradeService gradeService;

    @RequestMapping("")
    @RequiresPermissions("grade:index")
    @PermissionName("班级首页")
    public String index() {
        return "grade/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("grade:list")
    @PermissionName("班级数据")
    public PageResult list(GradeQueryObject qo)
    {
        return gradeService.query(qo);
    }

    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("grade:save")
    @PermissionName("班级保存")
    public JsonResult save(Grade grade) {
        JsonResult result = new JsonResult();
        try {
            gradeService.save(grade);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    @RequiresPermissions("grade:update")
    @PermissionName("班级更新")
    public JsonResult update(Grade grade) {
        JsonResult result = new JsonResult();
        try {
            gradeService.update(grade);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }

    @RequestMapping("changeState")
    @ResponseBody
    @RequiresPermissions("grade:changeState")
    @PermissionName("班级状态改变")
    public JsonResult changeState(Long id) {
        JsonResult result = new JsonResult();
        try {
            gradeService.changeState(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }

    //查班级方法
    @RequestMapping("queryGrades")
    @ResponseBody
    public List<Grade> queryGrades()
    {
        return gradeService.list();
    }

}
