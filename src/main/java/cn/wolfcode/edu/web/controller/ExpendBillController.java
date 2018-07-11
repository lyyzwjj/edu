package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.domain.ExpendBill;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IEmployeeService;
import cn.wolfcode.edu.service.IExpendBillService;
import cn.wolfcode.edu.util.JsonResult;
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

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(Long id) {
        JsonResult result = new JsonResult();
        try {
            expendBillService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public JsonResult save(ExpendBill exp) {
        JsonResult result = new JsonResult();
        try {
            expendBillService.save(exp);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    //审核操作
    @RequestMapping("/check")
    @ResponseBody
    public JsonResult check(Long id) {
        JsonResult result = new JsonResult();
        try {
            expendBillService.check(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("审核失败");
        }
        return result;
    }
}
