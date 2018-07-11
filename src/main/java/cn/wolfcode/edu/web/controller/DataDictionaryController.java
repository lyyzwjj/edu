package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.DataDictionary;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IDataDictionaryService;
import cn.wolfcode.edu.util.JsonResult;
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
    public String index(){
        return "/dataDictionary/list";
    }
    @RequestMapping("list")
    @ResponseBody
    public PageResult list(QueryObject qo){
        return dataDictionaryService.query(qo);
    }
    @ResponseBody
    @RequestMapping("save")
    public JsonResult save(DataDictionary dataDictionary){
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
    public JsonResult update(DataDictionary dataDictionary){
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
    public JsonResult delete(Long id){
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
