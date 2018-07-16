package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IEmployeeService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("changePassword")
public class ChangePasswordController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("")
    public String index() {
        return "changePassword/list";
    }


    @RequestMapping("list")
    @ResponseBody
    public PageResult list() {
        PageResult result = new PageResult();
        List<Employee> list = new ArrayList<>();
        Employee employee = (Employee) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        list.add(employee);
        result.setRows(list);
        result.setTotal(1);
        return result;
    }
}
