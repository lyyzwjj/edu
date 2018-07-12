package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("job")
public class JobController {
    @Autowired
    private IJobService jobService;

    @RequestMapping("")
    public String index() {
        return "job/list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageResult list(QueryObject qo) {
        PageResult result = jobService.query(qo);
        return result;
    }


}
