package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.domain.ExpendBill;
import cn.wolfcode.edu.query.ExpendBillQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IEmployeeService;
import cn.wolfcode.edu.service.IExpendBillService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
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
    @RequiresPermissions("expendbill:index")
    @PermissionName("支出首页")
    public String index(){
        return "expendbill/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("expendbill:list")
    @PermissionName("支出数据")
    public PageResult list(ExpendBillQueryObject qo){
        PageResult result = expendBillService.query(qo);
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    @RequiresPermissions("expendbill:delete")
    @PermissionName("支出删除")
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

    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("expendbill:save")
    @PermissionName("支出保存")
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
    @RequestMapping("check")
    @ResponseBody
    @RequiresPermissions("expendbill:check")
    @PermissionName("支出审核")
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
