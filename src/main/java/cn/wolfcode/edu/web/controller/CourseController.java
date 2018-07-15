package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Course;
import cn.wolfcode.edu.domain.Grade;
import cn.wolfcode.edu.query.CourseQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.ICourseService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @RequestMapping("")
    @RequiresPermissions("course:index")
    @PermissionName("课程表首页")
    public String index()
    {
        return "course/list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageResult list(CourseQueryObject qo)
    {
        return courseService.query(qo);
    }


    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("course:save")
    @PermissionName("课程表保存")
    public JsonResult save(Course course) {
        JsonResult result = new JsonResult();
        try {
            courseService.save(course);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }


    @RequestMapping("update")
    @ResponseBody
    @RequiresPermissions("course:update")
    @PermissionName("课程表更新")
    public JsonResult update(Course course) {
        JsonResult result = new JsonResult();
        try {
            courseService.update(course);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }

    @RequestMapping("today")
    @ResponseBody
    @RequiresPermissions("course:today")
    @PermissionName("课程表按时间查看")
    public List<Course> date(String data) throws ParseException {
        String string = data;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(string);
            System.out.println(date.toLocaleString().split(" ")[0]);//切割掉不要的时分秒数据
            courseService.querytodayByDate(date);
            //根据时间查询
            courseService.querytodayByDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return courseService.querytodayByDate(date);
    }

}
