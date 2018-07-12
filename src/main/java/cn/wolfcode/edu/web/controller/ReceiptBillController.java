package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.ReceiptBill;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IReceiptBillService;
import cn.wolfcode.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by WangZhe on 2018/7/10.
 */
@Controller
@RequestMapping("receiptbill")
public class ReceiptBillController {
    @Autowired
    private IReceiptBillService receiptBillService;

    @RequestMapping("")
    public String index(){
        return "receiptbill/list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(QueryObject qo){
        PageResult result = receiptBillService.query(qo);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
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

    @RequestMapping("/save")
    @ResponseBody
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
    
}
