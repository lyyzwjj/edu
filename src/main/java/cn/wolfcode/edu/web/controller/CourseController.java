package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Course;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.ICourseService;
import cn.wolfcode.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @RequestMapping("")
    public String index() {
        return "course/list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageResult list(QueryObject qo)
    {
        return courseService.query(qo);
    }

    @RequestMapping("save")
    @ResponseBody
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

    @RequestMapping("changeState")
    @ResponseBody
    public JsonResult changeState(Long id) {
        JsonResult result = new JsonResult();
        try {
            courseService.changeState(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }

    @RequestMapping("queryCours")
    @ResponseBody
    public List<Course> queryCours(){
        return courseService.list();
    }

    @RequestMapping("queryCourseIdsByGradeId")
    @ResponseBody
    public List<Long> queryCourseIdsByGradeId(Long gradeId){

        return courseService.queryCourseIdsByGradeId(gradeId);
    }
}
