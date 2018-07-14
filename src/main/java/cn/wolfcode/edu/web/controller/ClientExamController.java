package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.ClientExam;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IClientExamService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("clientExam")
public class ClientExamController {
    @Autowired
    private IClientExamService clientExamService;

    @RequestMapping("")
    @RequiresPermissions("clientExam:index")
    @PermissionName("客户考试首页")
    public String index() {
        return "clientExam/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("clientExam:list")
    @PermissionName("客户考试数据")
    public PageResult list(QueryObject qo) {
        PageResult result = clientExamService.query(qo);
        return result;
    }

    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("clientExam:save")
    @PermissionName("客户考试保存")
    public JsonResult save(ClientExam clientExam) {
        JsonResult result = new JsonResult();
        try {
            clientExamService.save(clientExam);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    @RequiresPermissions("clientExam:update")
    @PermissionName("客户考试更新")
    public JsonResult update(ClientExam clientExam) {
        JsonResult result = new JsonResult();
        try {
            clientExamService.update(clientExam);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }
    @RequestMapping("delete")
    @ResponseBody
    @RequiresPermissions("clientExam:delete")
    @PermissionName("客户考试删除")
    public JsonResult delete(Long id) {
        JsonResult result = new JsonResult();
        try {
            clientExamService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("删除失败");
        }
        return result;
    }

    //审核考试结果
    @RequestMapping("changeState")
    @ResponseBody
    @RequiresPermissions("clientExam:changeState")
    @PermissionName("客户考试审核")
    public JsonResult changeState(Long id) {
        JsonResult result = new JsonResult();
        try {
            clientExamService.changeState(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("审核失败");
        }
        return result;
    }

}
