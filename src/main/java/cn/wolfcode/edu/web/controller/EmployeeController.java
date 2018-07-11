package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.query.DepartmentQueryObject;
import cn.wolfcode.edu.query.PageResult;
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
    public PageResult list(DepartmentQueryObject qo) {
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
}
