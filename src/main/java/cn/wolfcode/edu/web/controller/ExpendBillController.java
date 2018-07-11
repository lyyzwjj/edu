package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IEmployeeService;
import cn.wolfcode.edu.service.IExpendBillService;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/10.
 */
@Controller
@RequestMapping("expendbill")
public class ExpendBillController {
    @Autowired
    private IExpendBillService expendBillService;

    @RequestMapping("")
    public String index(){
        return "expendbill/list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(QueryObject qo){
        PageResult result = expendBillService.query(qo);
        return result;
    }
}
