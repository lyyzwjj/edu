package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.ClientMajor;
import cn.wolfcode.edu.query.ClientMajorQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IClientMajorService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("clientMajor")
public class ClientMajorController {
    @Autowired
    private IClientMajorService clientMajorService;

    @RequestMapping("")
    @RequiresPermissions("clientMajor:index")
    @PermissionName("大客户首页")
    public String index() {
        return "clientMajor/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("clientMajor:list")
    @PermissionName("大客户列表")
    public PageResult list(ClientMajorQueryObject qo) {
        PageResult result = clientMajorService.query(qo);
        return result;
    }

    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("clientMajor:save")
    @PermissionName("大客户保存")
    public JsonResult save(ClientMajor clientMajor) {
        JsonResult result = new JsonResult();
        try {
            clientMajorService.save(clientMajor);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    @RequiresPermissions("clientMajor:update")
    @PermissionName("大客户更新")
    public JsonResult update(ClientMajor clientMajor) {
        JsonResult result = new JsonResult();
        try {
            clientMajorService.update(clientMajor);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }
    @RequestMapping("delete")
    @ResponseBody
    @RequiresPermissions("clientMajor:delete")
    @PermissionName("大客户删除")
    public JsonResult delete(Long id) {
        JsonResult result = new JsonResult();
        try {
            clientMajorService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("删除失败");
        }
        return result;
    }

}
