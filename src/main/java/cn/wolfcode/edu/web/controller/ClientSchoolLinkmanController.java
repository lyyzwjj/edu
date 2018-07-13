package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.ClientSchoolLinkman;
import cn.wolfcode.edu.query.ClientQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IClientSchoolLinkmanService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("clientSchoolLinkman")
public class ClientSchoolLinkmanController {
    @Autowired
    private IClientSchoolLinkmanService clientSchoolLinkmanService;

    @RequestMapping("")
    @RequiresPermissions("clientSchoolLinkman:index")
    @PermissionName("学校联系人首页")
    public String index() {
        return "clientSchoolLinkman/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("clientSchoolLinkman:list")
    @PermissionName("学校联系人列表")
    public PageResult list(ClientQueryObject qo) {
        PageResult result = clientSchoolLinkmanService.query(qo);
        return result;
    }

    //获取学校联系人的基本信息
    @RequestMapping("queryLinkman")
    @ResponseBody
    public List<ClientSchoolLinkman> queryLinkman() {
        return clientSchoolLinkmanService.list();
    }

    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("clientSchoolLinkman:save")
    @PermissionName("学校联系人保存")
    public JsonResult save(String birthday,String name) throws ParseException {
        ClientSchoolLinkman clientSchoolLinkman = new ClientSchoolLinkman();
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd");
        Date date = sdf.parse(birthday);
        clientSchoolLinkman.setBirthday(date);
        clientSchoolLinkman.setName(name);
        JsonResult result = new JsonResult();
        try {
            clientSchoolLinkmanService.save(clientSchoolLinkman);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    @RequiresPermissions("clientSchoolLinkman:update")
    @PermissionName("学校联系人更新")
    public JsonResult update(ClientSchoolLinkman clientSchoolLinkman) {
        JsonResult result = new JsonResult();
        try {
            clientSchoolLinkmanService.update(clientSchoolLinkman);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }
    @RequestMapping("delete")
    @ResponseBody
    @RequiresPermissions("clientSchoolLinkman:delete")
    @PermissionName("学校联系人删除")
    public JsonResult delete(Long id) {
        JsonResult result = new JsonResult();
        try {
            clientSchoolLinkmanService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("删除失败");
        }
        return result;
    }

}
