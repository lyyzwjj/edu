package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.SystemMenu;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.ISystemMenuService;
import cn.wolfcode.edu.util.JsonResult;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by WangZhe on 2018/7/12.
 */
@Controller
@RequestMapping("systemMenu")
public class SystemMenuController {
    @Autowired
    ISystemMenuService systemMenuService;
    @RequestMapping("")
    public String index(){
        return "/systemMenu/list";
    }
    @RequestMapping("list")
    @ResponseBody
    public PageResult list(QueryObject qo){
        return systemMenuService.query(qo);
    }
    @RequestMapping("save")
    @ResponseBody
    public JsonResult save(SystemMenu systemMenu){
        JsonResult result = new JsonResult();
        try {
            if ("".equals(systemMenu.getUrl().trim())){
                systemMenu.setUrl(null);
            }
            systemMenuService.save(systemMenu);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg(e.getMessage());
        }
            return result;
    }
    @RequestMapping("delete")
    @ResponseBody
    public JsonResult delete(Long id){
        JsonResult result = new JsonResult();
        try {
            systemMenuService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg(e.getMessage());
        }
            return result;
    }
    @RequestMapping("update")
    @ResponseBody
    public JsonResult update(SystemMenu systemMenu){
        JsonResult result = new JsonResult();
        try {
            if ("".equals(systemMenu.getUrl().trim())){
                systemMenu.setUrl(null);
            }
            systemMenuService.update(systemMenu);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg(e.getMessage());
        }
            return result;
    }

    @RequestMapping("data")
    public ModelAndView data(HttpServletResponse response) throws IOException {
        List<SystemMenu> list = systemMenuService.list();
        String jsonString = JSON.toJSONString(list);
        jsonString = jsonString.replace("\"parentId\":\"\",","");
        jsonString = jsonString.replace("parentId","_parentId");
        response.getWriter().write("{\"rows\":" + jsonString + "}");
        return null;
    }
    @ResponseBody
    @RequestMapping("queryAllParentSystemMenu")
    public List<SystemMenu> queryAllParentSystemMenu(){
        return systemMenuService.queryAllParentSystemMenu();
    }
}
