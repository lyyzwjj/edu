package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Client;
import cn.wolfcode.edu.query.ClientQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IClientService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("client")
public class ClientController {
    @Autowired
    private IClientService clientService;

    @RequestMapping("")
    @RequiresPermissions("client:index")
    @PermissionName("潜在客户首页")
    public String index() {
        return "client/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("client:list")
    @PermissionName("潜在客户列表")
    public PageResult list(ClientQueryObject qo) {
        PageResult result = clientService.query(qo);
        return result;
    }



    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("client:save")
    @PermissionName("潜在客户保存")
    public JsonResult save(Client client) {
        JsonResult result = new JsonResult();
        try {
            clientService.save(client);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    @RequiresPermissions("client:update")
    @PermissionName("潜在客户更新")
    public JsonResult update(Client client) {
        JsonResult result = new JsonResult();
        try {
            clientService.update(client);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }

    @RequestMapping("changeState")
    @ResponseBody
    @RequiresPermissions("client:changeState")
    @PermissionName("潜在客户删除")
    //没有这个方法
    public JsonResult changeState(Long id,Long stateId) {
        JsonResult result = new JsonResult();
        try {
            clientService.changeState(id,stateId);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("转正失败");
        }
        return result;
    }

    @RequestMapping("queryClients")
    @ResponseBody
    public List<Client> queryClients(ClientQueryObject qo) {
        List<Client> list = clientService.queryClients();
        return list;
    }

    /**
     * 资源池客户列表
     * @param qo
     * @return
     */
    @RequestMapping("queryPoolClient")
    @ResponseBody
    public List<Client> queryPoolClient() {
        List<Client> list = clientService.queryPoolClient();
        return list;
    }

}
