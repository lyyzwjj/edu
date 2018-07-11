package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Department;
import cn.wolfcode.edu.query.DepartmentQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IDepartmentService;
import cn.wolfcode.edu.util.JsonResult;
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
    public String index(){
        return "department/list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageResult list(DepartmentQueryObject qo){
        return departmentService.query(qo);
    }

    @RequestMapping("save")
    @ResponseBody
    public JsonResult save(Department entity){
       JsonResult result=new JsonResult();
        try {
            departmentService.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存操作失败!");
        }
        return result;
    }
    @RequestMapping("update")
    @ResponseBody
    public JsonResult update(Department entity){
        JsonResult result=new JsonResult();
        try {
            departmentService.update(entity);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("编辑操作失败!");
        }
        return result;
    }
    @RequestMapping("changeState")
    @ResponseBody
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
