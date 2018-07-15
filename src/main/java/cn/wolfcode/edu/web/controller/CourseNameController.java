package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.CourseName;
import cn.wolfcode.edu.query.CourseNameQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.ICourseNameService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("courseName")
public class CourseNameController {

    @Autowired
    private ICourseNameService courseNameService;

    @RequestMapping("")
    @RequiresPermissions("courseName:index")
    @PermissionName("课程系列首页")
    public String index() {
        return "courseName/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("courseName:list")
    @PermissionName("课程系列数据")
    public PageResult list(CourseNameQueryObject qo)
    {
        return courseNameService.query(qo);
    }

    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("courseName:save")
    @PermissionName("课程系列保存")
    public JsonResult save(CourseName courseName) {
        JsonResult result = new JsonResult();
        try {
            courseNameService.save(courseName);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }


    @RequestMapping("changeState")
    @ResponseBody
    @RequiresPermissions("course:changeState")
    @PermissionName("课程系列审核")
    public JsonResult changeState(Long id) {
        JsonResult result = new JsonResult();
        try {
            courseNameService.changeState(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }

    @RequestMapping("queryCours")
    @ResponseBody
    public List<CourseName> queryCours()
    {
        return courseNameService.list();
    }

    @RequestMapping("queryCourseIdsByGradeId")
    @ResponseBody
    public List<Long> queryCourseIdsByGradeId(Long gradeId){

        return courseNameService.queryCourseIdsByGradeId(gradeId);
    }
}
