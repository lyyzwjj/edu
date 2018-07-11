package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IEmployeeService;
import cn.wolfcode.edu.service.IExpendBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by WangZhe on 2018/7/10.
 */
@Controller
@RequestMapping("expendbill")
public class ExpendBillController {
    @Autowired
    private IExpendBillService expendBillService;
    @RequestMapping("list")
    public String list(Model model, QueryObject qo){
        model.addAttribute("list",expendBillService.query(qo));
        return "expendbill/list";
    }
}
