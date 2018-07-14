package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IJobService;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("job")
public class JobController {
    @Autowired
    private IJobService jobService;

    @RequestMapping("")
    @RequiresPermissions("job:index")
    @PermissionName("职务首页")
    public String index() {
        return "job/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("job:list")
    @PermissionName("职务数据")
    public PageResult list(QueryObject qo) {
        PageResult result = jobService.query(qo);
        return result;
    }


}
