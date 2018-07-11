package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("classRoom")
public class ClassRoomController {

    @Autowired
    private IClassRoomService classRoomService;

    @RequestMapping("list")
    @ResponseBody
    public PageResult list(QueryObject qo){
        return classRoomService.query(qo);
    }

}
