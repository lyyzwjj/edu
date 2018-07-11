package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.ExpendBill;
import cn.wolfcode.edu.domain.PayMent;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IExpendBillService;
import cn.wolfcode.edu.service.IPayMentService;
import cn.wolfcode.edu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/10.
 */
@Controller
@RequestMapping("payment")
public class PayMentController {
    @Autowired
    private IPayMentService payMentService;

    @RequestMapping("/queryPayments")
    @ResponseBody
    public List<PayMent> queryPayments(){
        return payMentService.list();
    }
}
