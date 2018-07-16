package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.query.DepartmentQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.ISignService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by WangZhe on 2018/7/16.
 */
@Controller
@RequestMapping("sign")
public class SignController {
    @Autowired
    private ISignService signService;

    @RequestMapping("signIn")
    @ResponseBody
    public JsonResult singIn(){
        JsonResult result = new JsonResult();
        try {
            signService.signIn();
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("签到失败");
        }
        return result;
    }
    @RequestMapping("signOut")
    @ResponseBody
    public JsonResult singOut(){
        JsonResult result = new JsonResult();
        try {
            signService.signOut();
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("签退失败");
        }
        return result;
    }

    @RequestMapping("")
    public String index() {
        return "sign/list";
    }

    @RequestMapping("selfList")
    @ResponseBody
    public PageResult list(DepartmentQueryObject qo) {
        PageResult result = signService.query(qo);
        return result;
    }
}
