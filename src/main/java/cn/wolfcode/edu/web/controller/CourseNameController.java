package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.CourseName;
import cn.wolfcode.edu.query.CourseNameQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.ICourseNameService;
import cn.wolfcode.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("courseName")
public class CourseNameController {

    @Autowired
    private ICourseNameService courseNameService;

    @RequestMapping("")
    public String index() {
        return "courseName/list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageResult list(CourseNameQueryObject qo)
    {
        return courseNameService.query(qo);
    }

    @RequestMapping("save")
    @ResponseBody
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
}
