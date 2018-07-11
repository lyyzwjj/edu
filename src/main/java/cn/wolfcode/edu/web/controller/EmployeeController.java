package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.query.EmployeeQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IEmployeeService;
import cn.wolfcode.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("")
    public String index() {
        return "employee/list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageResult list(EmployeeQueryObject qo) {
        PageResult result = employeeService.query(qo);
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public JsonResult save(Employee employee) {
        JsonResult result = new JsonResult();
        try {
            employeeService.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(Employee employee) {
        JsonResult result = new JsonResult();
        try {
            employeeService.update(employee);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(Long id) {
        JsonResult result = new JsonResult();
        try {
            employeeService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("queryTeachers")
    @ResponseBody
    public List<Employee> queryTeachers(){
        return employeeService.list();
    }

    @RequestMapping("/changeState")
    @ResponseBody
    public JsonResult changeState(Long id) {
        JsonResult result = new JsonResult();
        try {
            employeeService.changeState(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("操作失败");
        }
        return result;
    }
    //chenfen添加 用于获取employee的name等 就是不需要分页效果
    @RequestMapping("queryEmployee")
    @ResponseBody
    public List<Employee> queryEmployeeName(QueryObject qo) {
        return employeeService.list();
    }

}
