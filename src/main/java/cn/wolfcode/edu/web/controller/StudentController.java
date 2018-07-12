package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Client;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.StudentQueryObject;
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
@RequestMapping("student")
public class StudentController {
    @Autowired
    private IClientService clientService;

    @RequestMapping("")
    @RequiresPermissions("student:index")
    @PermissionName("学员首页")
    public String index() {
        return "student/list";
    }

    @RequestMapping("/update")
    @ResponseBody
    @RequiresPermissions("student:update")
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

    @RequestMapping("queryStudents")
    @ResponseBody
    public List<Client> queryClients(StudentQueryObject qo) {
        List<Client> list = clientService.queryClients(qo);
        return list;
    }
}
