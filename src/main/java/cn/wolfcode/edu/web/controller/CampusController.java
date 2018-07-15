package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Campus;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.ICampusService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("campus")
public class CampusController {

    @Autowired
    private ICampusService campusService;
    @RequestMapping("")
    @PermissionName("校区列表")
    public String index(){
        return "campus/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("campus:list")
    @PermissionName("校区数据")
    public List<Campus> list(){
        return campusService.list();
    }

}
