package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.TalentPool;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.TalentPoolQueryObject;
import cn.wolfcode.edu.service.ITalentPoolService;
import cn.wolfcode.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("talentPool")
public class TalentPoolController {

    @Autowired
    private ITalentPoolService talentPoolService;

    @RequestMapping("")
    public String index() {
        return "talentPool/list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageResult list(TalentPoolQueryObject qo)
    {
        return talentPoolService.query(qo);
    }

    @RequestMapping("save")
    @ResponseBody
    public JsonResult save(TalentPool talentPool) {
        JsonResult result = new JsonResult();
        try {
            talentPoolService.save(talentPool);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    public JsonResult update(TalentPool talentPool) {
        JsonResult result = new JsonResult();
        try {
            talentPoolService.update(talentPool);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }

}
