package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.ReceiptBill;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.ReceiptBillQueryObject;
import cn.wolfcode.edu.service.IReceiptBillService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/10.
 */
@Controller
@RequestMapping("receiptbill")
public class ReceiptBillController {
    @Autowired
    private IReceiptBillService receiptBillService;

    @RequestMapping("")
    @RequiresPermissions("receiptbill:index")
    @PermissionName("收款明细首页")
    public String index(){
        return "receiptbill/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("receiptbill:list")
    @PermissionName("收款明细数据")
    public PageResult list(ReceiptBillQueryObject qo){
        PageResult result = receiptBillService.query(qo);
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    @RequiresPermissions("receiptbill:delete")
    @PermissionName("收款明细删除")
    public JsonResult delete(Long id) {
        JsonResult result = new JsonResult();
        try {
            receiptBillService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("receiptbill:save")
    @PermissionName("收款明细保存")
    public JsonResult save(ReceiptBill exp) {
        JsonResult result = new JsonResult();
        try {
            receiptBillService.save(exp);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    //审核操作
    @RequestMapping("check")
    @ResponseBody
    @RequiresPermissions("receiptbill:check")
    @PermissionName("收款明细审核")
    public JsonResult check(Long id) {
        JsonResult result = new JsonResult();
        try {
            receiptBillService.check(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("审核失败");
        }
        return result;
    }

    @RequestMapping("/queryAllBills")
    @ResponseBody
    public List<ReceiptBill> queryAllBills(){
        List<ReceiptBill> list = receiptBillService.list();
        return list;
    }
}
