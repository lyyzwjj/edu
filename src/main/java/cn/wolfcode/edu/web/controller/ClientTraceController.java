package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.ClientTrace;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IClientTraceService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("clientTrace")
public class ClientTraceController {
    @Autowired
    private IClientTraceService clientTraceService;

    @RequestMapping("")
    @RequiresPermissions("clientTrace:index")
    @PermissionName("客户追踪首页")
    public String index() {
        return "clientTrace/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("clientTrace:list")
    @PermissionName("客户追踪数据")
    public PageResult list(QueryObject qo) {
        PageResult result = clientTraceService.query(qo);
        return result;
    }

    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("clientTrace:save")
    @PermissionName("客户追踪保存")
    public JsonResult save(ClientTrace clientTrace) {
        JsonResult result = new JsonResult();
        try {
            clientTraceService.save(clientTrace);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    @RequiresPermissions("clientTrace:update")
    @PermissionName("客户追踪更新")
    public JsonResult update(ClientTrace clientTrace) {
        JsonResult result = new JsonResult();
        try {
            clientTraceService.update(clientTrace);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }



}
