package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by WangZhe on 2018/7/10.
 */
@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @RequestMapping("list")
    public String list(Model model){
        model.addAttribute("list",employeeService.list());
        return "/employee/list";
    }
}
