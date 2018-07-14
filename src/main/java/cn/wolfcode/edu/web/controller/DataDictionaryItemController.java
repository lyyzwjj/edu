package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.DataDictionary;
import cn.wolfcode.edu.domain.DataDictionaryItem;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IDataDictionaryItemService;
import cn.wolfcode.edu.service.IDataDictionaryService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/11.
 */
@Controller
@RequestMapping("dataDictionaryItem")
public class DataDictionaryItemController {
    @Autowired
    private IDataDictionaryItemService dataDictionaryItemService;
    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("dataDictionaryItem:list")
    @PermissionName("字典明细数据")
    public List<DataDictionaryItem> list(){
        return dataDictionaryItemService.list();
    }
    @RequestMapping("queryListByParent")
    @ResponseBody
    @RequiresPermissions("dataDictionaryItem:queryListByParent")
    @PermissionName("根据字典查找字典明细数据")
    public List<DataDictionaryItem> queryListByParent(Long parentId){
        return dataDictionaryItemService.queryListByParent(parentId);
    }
    @ResponseBody
    @RequestMapping("save")
    @RequiresPermissions("dataDictionaryItem:save")
    @PermissionName("字典明细保存")
    public JsonResult save(DataDictionaryItem dataDictionaryItem){
        JsonResult result = new JsonResult();
        try {
            dataDictionaryItemService.save(dataDictionaryItem);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg(e.getMessage());
        }
        return result;
    }
    @RequestMapping("update")
    @ResponseBody
    @RequiresPermissions("dataDictionaryItem:update")
    @PermissionName("字典明细更新")
    public JsonResult update(DataDictionaryItem dataDictionaryItem){
        JsonResult result = new JsonResult();
        try {
            dataDictionaryItemService.update(dataDictionaryItem);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg(e.getMessage());
        }
        return result;
    }
    @RequestMapping("delete")
    @ResponseBody
    @RequiresPermissions("dataDictionaryItem:delete")
    @PermissionName("字典明细删除")
    public JsonResult delete(Long id){
        JsonResult result = new JsonResult();
        try {
            dataDictionaryItemService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg(e.getMessage());
        }
        return result;
    }
}
