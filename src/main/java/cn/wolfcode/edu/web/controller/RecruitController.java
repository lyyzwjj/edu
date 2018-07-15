package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Recruit;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IRecruitService;
import cn.wolfcode.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("recruit")
public class RecruitController {
    @Autowired
    private IRecruitService recruitService;

    @RequestMapping("")
    public String index() {
        return "recruit/list";
    }

    @RequestMapping("queryRecruits")
    @ResponseBody
    public List<Recruit> queryRecruits() {
        List<Recruit> recruits = recruitService.selectAll();
        return recruits;
    }

    @RequestMapping("queryByRecruitId")
    @ResponseBody
    public List<Recruit> queryByRecruitId(Long recruitId) {
        List<Recruit> recruits = recruitService.queryByRecruitId(recruitId);
        return recruits;
    }

    @RequestMapping("list")
    @ResponseBody
    public PageResult list(QueryObject qo) {
        PageResult result = recruitService.query(qo);
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public JsonResult save(Recruit recruit) {
        JsonResult result = new JsonResult();
        try {
            recruitService.insert(recruit);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(Recruit recruit) {
        JsonResult result = new JsonResult();
        try {
            recruitService.updateByPrimaryKey(recruit);
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
            recruitService.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("删除失败");
        }
        return result;
    }

 /*   @RequestMapping("/changeState")
    @ResponseBody
    public JsonResult changeState(Long id) {
        JsonResult result = new JsonResult();
        try {
            recruitService.changeState(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("操作失败");
        }
        return result;
    }*/

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public JsonResult saveOrUpdate(Recruit recruit) {
        JsonResult result = new JsonResult();
        try {
            if (recruit.getId() == null) {
                recruitService.insert(recruit);
            } else {
                recruitService.updateByPrimaryKey(recruit);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }


}
