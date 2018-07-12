package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Employee;
import cn.wolfcode.edu.query.EmployeeQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IEmployeeService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("")
    public String index() {
        return "employee/list";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageResult list(EmployeeQueryObject qo) {
        PageResult result = employeeService.query(qo);
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public JsonResult save(Employee employee) {
        JsonResult result = new JsonResult();
        try {
            employeeService.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(Employee employee) {
        JsonResult result = new JsonResult();
        try {
            employeeService.update(employee);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(Long id) {
        JsonResult result = new JsonResult();
        try {
            employeeService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/changeState")
    @ResponseBody
    public JsonResult changeState(Long id) {
        JsonResult result = new JsonResult();
        try {
            employeeService.changeState(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("操作失败");
        }
        return result;
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public JsonResult saveOrUpdate(Employee employee) {
        JsonResult result = new JsonResult();
        try {
            if (employee.getId() == null) {
                employeeService.save(employee);
            } else {
                employeeService.update(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }

    //查班主任方法
    @RequestMapping("queryTeachers")
    @ResponseBody
    public List<Employee> queryTeachers() {
        return employeeService.list();
    }


    //图片上传
    @RequestMapping("upload")
    @ResponseBody
    public JsonResult upload(MultipartFile file, Long staff_id, String portrait, HttpServletRequest request) {
        JsonResult result = new JsonResult();
        ServletContext servletContext = request.getServletContext();
        try {
            if (!StringUtils.isEmpty(file) && file.getSize() > 0L && !StringUtils.isEmpty(portrait))
                UploadUtil.deleteFile(servletContext, portrait);
            if (!StringUtils.isEmpty(file) && file.getSize() > 0L) {

                String realPath = servletContext.getRealPath("/upload");
                String upload = UploadUtil.upload(file, realPath);
                System.out.println(upload+"================================================================================");
                System.out.println(staff_id+"================================================================================");
                employeeService.uploadPortrait(staff_id, upload);
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("上传失败");
        }
        return result;
    }
}
