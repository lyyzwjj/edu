package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.DataDictionary;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IDataDictionaryService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by WangZhe on 2018/7/11.
 */
@Controller
@RequestMapping("dataDictionary")
public class DataDictionaryController {
    @Autowired
    private IDataDictionaryService dataDictionaryService;

    @RequestMapping("")
    @RequiresPermissions("dataDictionary:index")
    @PermissionName("字典首页")
    public String index() {
        return "/dataDictionary/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("dataDictionary:list")
    @PermissionName("字典数据")
    public PageResult list(QueryObject qo) {
        return dataDictionaryService.query(qo);
    }

    @ResponseBody
    @RequestMapping("save")
    @RequiresPermissions("dataDictionary:save")
    @PermissionName("字典保存")
    public JsonResult save(DataDictionary dataDictionary) {
        JsonResult result = new JsonResult();
        try {
            dataDictionaryService.save(dataDictionary);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    @RequiresPermissions("dataDictionary:update")
    @PermissionName("字典更新")
    public JsonResult update(DataDictionary dataDictionary) {
        JsonResult result = new JsonResult();
        try {
            dataDictionaryService.update(dataDictionary);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    @RequiresPermissions("dataDictionary:delete")
    @PermissionName("字典删除")
    public JsonResult delete(Long id) {
        JsonResult result = new JsonResult();
        try {
            dataDictionaryService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg(e.getMessage());
        }
        return result;
    }
}
