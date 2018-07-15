package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.service.IRecruitService;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("recruitItem")
public class RecruitItemController {
    @Autowired
    private IRecruitService recruitService;

    @RequestMapping("")
    @RequiresPermissions("recruitItem:index")
    @PermissionName("招聘计划明细首页")
    public String index() {
        return "recruitItem/list";
    }

}
