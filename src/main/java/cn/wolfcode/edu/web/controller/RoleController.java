package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Role;
import cn.wolfcode.edu.query.DepartmentQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IRoleService;
import cn.wolfcode.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping("")
    public String index() {
        return "role/list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageResult list(DepartmentQueryObject qo) {
        PageResult result = roleService.query(qo);
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public JsonResult save(Role role) {
        JsonResult result = new JsonResult();
        try {
            roleService.save(role);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(Role role) {
        JsonResult result = new JsonResult();
        try {
            roleService.update(role);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(Long id) {
        JsonResult result = new JsonResult();
        try {
            roleService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("删除失败");
        }
        return result;
    }


}
