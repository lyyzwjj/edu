package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.ClientTransferRecord;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IClientTransferRecordService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("clientTransferRecord")
public class ClientTransferRecordController {
    @Autowired
    private IClientTransferRecordService service;

    @RequestMapping("")
    @RequiresPermissions("clientTransferRecord:index")
    @PermissionName("转移记录首页")
    public String index() {
        return "clientTransferRecord/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("clientTransferRecord:list")
    @PermissionName("转移记录数据")
    public PageResult list(QueryObject qo) {
        PageResult result = service.query(qo);
        return result;
    }
    
    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("clientTransferRecord:save")
    @PermissionName("转移记录保存")
    public JsonResult save(ClientTransferRecord clientTransferRecord) {
        JsonResult result = new JsonResult();
        try {
            service.save(clientTransferRecord);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }




}
