package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Work;
import cn.wolfcode.edu.service.IWorkService;
import cn.wolfcode.edu.util.JsonResult;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("work")
public class WorkController {

    @Autowired
    private IWorkService workService;

    @RequestMapping("")
    public String index() {
        return "work/list";
    }

    @RequestMapping("list")
    @ResponseBody
    public List<Work> list() {
        List<Work> families = workService.selectAll();
        return families;
    }

    @RequestMapping("/saveWork")
    @ResponseBody
    public JsonResult saveWork(String rows) {
        JsonResult result = new JsonResult();
        try {
            List<Work> families = JSON.parseArray(rows, Work.class);
            workService.delete(families.get(0).getStaff_id());
            for (Work work : families) {
                workService.insert(work);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(Work work) {
        JsonResult result = new JsonResult();
        try {
            workService.updateByPrimaryKey(work);
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
            workService.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("queryByStaffId")
    @ResponseBody
    public List<Work> queryByStaffId(Long staff_id) {
        List<Work> families = workService.queryByStaffId(staff_id);
        return families;
    }

}
