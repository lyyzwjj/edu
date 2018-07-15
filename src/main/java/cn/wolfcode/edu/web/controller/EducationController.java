package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Education;
import cn.wolfcode.edu.service.IEducationService;
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
@RequestMapping("education")
public class EducationController {

    @Autowired
    private IEducationService educationService;

    @RequestMapping("")
    @RequiresPermissions("education:index")
    @PermissionName("学历首页")
    public String index() {
        return "education/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("education:list")
    @PermissionName("学历数据")
    public List<Education> list() {
        List<Education> educations = educationService.selectAll();
        return educations;
    }

    @RequestMapping("saveEducation")
    @ResponseBody
    @RequiresPermissions("education:saveEducation")
    @PermissionName("学历保存")
    public JsonResult saveEducation(String rows) {
        JsonResult result = new JsonResult();
        try {
            List<Education> educations = JSON.parseArray(rows, Education.class);
            educationService.delete(educations.get(0).getStaff_id());
            for (Education education : educations) {
                educationService.insert(education);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    @RequiresPermissions("education:update")
    @PermissionName("学历更新")
    public JsonResult update(Education education) {
        JsonResult result = new JsonResult();
        try {
            educationService.updateByPrimaryKey(education);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    @RequiresPermissions("education:delete")
    @PermissionName("学历删除")
    public JsonResult delete(Long id) {
        JsonResult result = new JsonResult();
        try {
            educationService.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("queryByStaffId")
    @ResponseBody
    public List<Education> queryByStaffId(Long staff_id) {
        List<Education> educations = educationService.queryByStaffId(staff_id);
        return educations;
    }

}
