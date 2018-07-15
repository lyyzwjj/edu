package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Family;
import cn.wolfcode.edu.service.IFamilyService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("family")
public class FamilyController {

    @Autowired
    private IFamilyService familyService;

    @RequestMapping("")
    @RequiresPermissions("family:index")
    @PermissionName("员工家庭首页")
    public String index() {
        return "family/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("family:list")
    @PermissionName("员工家庭数据")
    public List<Family> list() {
        List<Family> families = familyService.selectAll();
        return families;
    }

    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("family:save")
    @PermissionName("员工家庭保存")
    public JsonResult saveFamily(String rows) {
        JsonResult result = new JsonResult();
        try {
            List<Family> families = JSON.parseArray(rows, Family.class);
            familyService.delete(families.get(0).getStaff_id());
            for (Family family : families) {
                familyService.insert(family);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    @RequiresPermissions("family:update")
    @PermissionName("员工家庭更新")
    public JsonResult update(Family family) {
        JsonResult result = new JsonResult();
        try {
            familyService.updateByPrimaryKey(family);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    @RequiresPermissions("family:delete")
    @PermissionName("员工家庭删除")
    public JsonResult delete(Long id) {
        JsonResult result = new JsonResult();
        try {
            familyService.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("queryByStaffId")
    @ResponseBody
    public List<Family> queryByStaffId(Long staff_id) {
        List<Family> families = familyService.queryByStaffId(staff_id);
        return families;
    }

}
