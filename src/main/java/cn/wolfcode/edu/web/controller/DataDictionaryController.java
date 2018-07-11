package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IDataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public PageResult list(QueryObject qo){
        return dataDictionaryService.query(qo);
    }
}
