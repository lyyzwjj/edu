package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Client;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.StudentQueryObject;
import cn.wolfcode.edu.service.IClientService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private IClientService clientService;

    @RequestMapping("")
    @RequiresPermissions("student:index")
    @PermissionName("学员首页")
    public String index() {
        return "student/list";
    }

    @RequestMapping("/updateByStudent")
    @ResponseBody
    @RequiresPermissions("student:update")
    @PermissionName("学员更新")
    public JsonResult update(Client client) {
        JsonResult result = new JsonResult();
        try {
            clientService.updateByStudent(client);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }

    @RequestMapping("queryStudents")
    @ResponseBody
    @RequiresPermissions("student:queryStudents")
    @PermissionName("学员高级查询")
    public List<Client> queryClients(StudentQueryObject qo) {
        List<Client> list = clientService.queryClients(qo);
        return list;
    }

    @RequestMapping("queryClients")
    @ResponseBody
    public List<Client> list() {
        List<Client> list = clientService.listStudents();
        return list;
    }

    @RequestMapping("/trend")
    @ResponseBody
    public JsonResult trend(Long id) {
        JsonResult result = new JsonResult();
        try {
            clientService.changeTrend(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("操作失败");
        }
        return result;
    }

    @RequestMapping("/export")
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response, StudentQueryObject qo) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");

        //文件名
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = sdf.format((new Date())) + ".xls";

        response.setContentType("application/msexcel");
        response.setCharacterEncoding("UTF-8");
        response.addHeader("Content-Disposition","attachment;filename=" + fileName);

        List<Client> list = clientService.queryClients(qo);


        try {


            String titles = request.getParameter("titles");
            String[] split = titles.split(",");

            //创建excel文件
            WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream());
            //创建页签
            WritableSheet sheet = workbook.createSheet("员工列表", 0);
            //创建单元格
            List<String> header = new ArrayList<>();
            for (String s : split) {
                s = URLDecoder.decode(s, "UTF-8");
                header.add(s);
            }
            Label label = null;
            for (int i = 0; i < header.size(); i++){
                label = new Label(i,0,header.get(i));
                sheet.addCell(label);
            }

            for (int i = 1; i < list.size() + 1; i++){
                Client client = list.get(i - 1);
                label = new Label(0, i, (client.getId()).toString());
                sheet.addCell(label);
                label = new Label(1, i, client.getName());
                sheet.addCell(label);
                label = new Label(2, i, client.getSaleMan().getRealname());
                sheet.addCell(label);
                label = new Label(3, i, (client.getStudentReceiptGather().getTotalmoney()).toString());
                sheet.addCell(label);
                label = new Label(4, i, (client.getStudentReceiptGather().getTotalreceiptmoney()).toString());
                sheet.addCell(label);
                label = new Label(5, i, (client.getStudentReceiptGather().getUnpaidmoney()).toString());
                sheet.addCell(label);
                label = new Label(6, i, client.getTel());
                sheet.addCell(label);
                label = new Label(7, i, client.getEmail());
                sheet.addCell(label);
                label = new Label(8, i, Integer.toString(client.getStateId()));
                sheet.addCell(label);
            }

            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
