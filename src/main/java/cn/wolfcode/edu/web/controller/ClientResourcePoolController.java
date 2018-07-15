package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IClientService;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("clientResourcePool")
public class ClientResourcePoolController {
    @Autowired
    private IClientService service;
    @RequestMapping("")
    @RequiresPermissions("clientResourcePool:index")
    @PermissionName("客户资源池首页")
    public String index() {
        return "clientResourcePool/list";
    }

    /**
     * 资源池客户列表
     * @param qo
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("clientResourcePool:list")
    @PermissionName("客户资源池数据")
    public PageResult queryPoolClient(QueryObject qo) {
        PageResult result = service.queryPoolClient(qo);
        return result;
    }

}
