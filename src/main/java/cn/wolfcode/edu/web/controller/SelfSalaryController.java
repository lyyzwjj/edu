package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.domain.Salary;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.ISalaryService;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;


/**
 * Created by WangZhe on 2018/7/15.
 */
@Controller
@RequestMapping("selfSalary")
public class SelfSalaryController {
    @Autowired
    private ISalaryService salaryService;

    @RequestMapping("")
    @PermissionName("个人工资首页")
    @RequiresPermissions("selfSalary:index")
    public String index() {
        return "/selfSalary/list";
    }

    @RequestMapping("list")
    @RequiresPermissions("selfSalary:list")
    @PermissionName("个人工资数据")
    @ResponseBody
    public PageResult list() {
        Employee currentUser = (Employee) SecurityUtils.getSubject().getPrincipal();
        PageResult result = new PageResult();
        ArrayList<Salary> list = new ArrayList<>();
        list.add(salaryService.queryByIdentifier(currentUser.getId()));
        result.setRows(list);
        result.setTotal(1);
        return result;
    }
}
