package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Job;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IJobService;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import cn.wolfcode.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("job")
public class JobController {
    @Autowired
    private IJobService jobService;

    @RequestMapping("")
    @RequiresPermissions("job:index")
    @PermissionName("职务首页")
    public String index() {
        return "job/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("job:list")
    @PermissionName("职务数据")
    public PageResult list(QueryObject qo) {
        PageResult result = jobService.query(qo);
        return result;
    }


    @RequestMapping("selectAll")
    @ResponseBody
    public List<Job> selectAll() {
        List<Job> jobs = jobService.selectAll();
        return jobs;
    }



    @RequestMapping("/save")
    @ResponseBody
    public JsonResult save(Job job) {
        JsonResult result = new JsonResult();
        try {
            jobService.insert(job);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(Job job) {
        JsonResult result = new JsonResult();
        try {
            jobService.updateByPrimaryKey(job);
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
            jobService.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("删除失败");
        }
        return result;
    }
}
