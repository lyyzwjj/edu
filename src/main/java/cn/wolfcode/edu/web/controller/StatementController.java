package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Char;
import cn.wolfcode.edu.query.StatementQueryObject;
import cn.wolfcode.edu.service.IStatementService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("statement")
public class StatementController {
    @Autowired
    private IStatementService service;

   @RequestMapping("")
    public String index(){
       return "/statement/list";
    }

     @RequestMapping("list")
     @ResponseBody
    public List<Map<String, Object>> selectStatement(StatementQueryObject qo){
        return service.selectStatement(qo);
    }


    @RequestMapping("queryGroupType")
    @ResponseBody
    public List<Char> queryGroupType(){
        List<Char> groupByTypes = new ArrayList<>();
        for (Map.Entry<String, String> entry : StatementQueryObject.groupByTypes.entrySet()) {
            Char aChar = new Char();
            aChar.setGroupByType(entry.getKey());
            aChar.setValue(entry.getValue());
            groupByTypes.add(aChar);
        }
        return groupByTypes;
    }
        @RequestMapping("car")
        public String car(Model model,StatementQueryObject qo) {
            model.addAttribute("groupByType",StatementQueryObject.groupByTypes.get(qo.getGroupByType()));
            List<Map<String,Object>> saleChart = service.selectStatement(qo);
            ArrayList<Object> groupByTypes = new ArrayList<>();
            ArrayList<Object> receiptmoneys = new ArrayList<>();
            for (Map<String,Object> map : saleChart) {
                groupByTypes.add(map.get("groupByType"));
                receiptmoneys.add(map.get("receiptmoney"));
            }
            model.addAttribute("groupByTypes", JSON.toJSONString(groupByTypes));
            model.addAttribute("receiptmoneys", JSON.toJSONString(receiptmoneys));
            return "/statement/car";
    }
    @RequestMapping("pie")
    public String pie(Model model, @ModelAttribute("qo")StatementQueryObject qo) {
        model.addAttribute("groupByType", StatementQueryObject.groupByTypes.get(qo.getGroupByType()));
        List<Map<String,Object>> saleChart = service.selectStatement(qo);
        ArrayList<Object> groupByTypes = new ArrayList<>();
        List<Map<String,Object>> datas = new ArrayList<>();
        for (Map<String,Object> map : saleChart) {
            groupByTypes.add(map.get("groupByType"));
            Map<String, Object> data = new HashMap<>();
            data.put("value", map.get("receiptmoney"));
            data.put("name", map.get("groupByType"));
            datas.add(data);
        }
        model.addAttribute("groupByTypes", JSON.toJSONString(groupByTypes));
        model.addAttribute("datas", JSON.toJSONString(datas));
        return "/statement/pie";
}
}
