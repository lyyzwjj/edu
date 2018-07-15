package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.TalentPool;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.TalentPoolQueryObject;
import cn.wolfcode.edu.service.ITalentPoolService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
    @RequiresPermissions("talentPool:index")
    @PermissionName("人才储备库首页")
    public String index() {
        return "talentPool/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("talentPool:list")
    @PermissionName("人才储备库数据")
    public PageResult list(TalentPoolQueryObject qo)
    {
        return talentPoolService.query(qo);
    }

    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("talentPool:save")
    @PermissionName("人才储备库保存")
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
    @RequiresPermissions("talentPool:update")
    @PermissionName("人才储备库更新")
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
