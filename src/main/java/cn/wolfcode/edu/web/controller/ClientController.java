package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Client;
import cn.wolfcode.edu.query.ClientQueryObject;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.service.IClientService;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("client")
public class ClientController {
    @Autowired
    private IClientService clientService;

    @RequestMapping("")
    @RequiresPermissions("client:index")
    @PermissionName("潜在客户首页")
    public String index() {
        return "client/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("client:list")
    @PermissionName("潜在客户数据")
    public PageResult list(ClientQueryObject qo) {
        PageResult result = clientService.query(qo);
        return result;
    }

    @RequestMapping("save")
    @ResponseBody
    @RequiresPermissions("client:save")
    @PermissionName("潜在客户保存")
    public JsonResult save(Client client) {
        JsonResult result = new JsonResult();
        try {
            clientService.save(client);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    @RequiresPermissions("client:update")
    @PermissionName("潜在客户更新")
    public JsonResult update(Client client) {
        JsonResult result = new JsonResult();
        try {
            clientService.update(client);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("更新失败");
        }
        return result;
    }

    @RequestMapping("changeState")
    @ResponseBody
    @RequiresPermissions("client:changeState")
    @PermissionName("潜在客户转正")
    public JsonResult changeState(Long id,int stateId) {
        JsonResult result = new JsonResult();
        try {
            clientService.changeState(id,stateId);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("转正失败");
        }
        return result;
    }
    @RequestMapping("queryClients")
    @ResponseBody
    public List<Client> queryClients(){
        return clientService.list();
    }

    //导出列表
    @RequestMapping("export")
    public void export(HttpServletResponse response) {

        //设置文件名
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = sdf.format(new Date()) + ".xls";

        response.setContentType("application/x-excel");
        response.setCharacterEncoding("UTF-8");
        //excel文件名
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        List<Client> list = clientService.list();

        try {
            //创建工作簿
            WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream());

            //创建页签
            WritableSheet sheet = workbook.createSheet("潜在客户信息", 0);
            //创建单元格
            String[] header = {"客户编号", "客户姓名", "营销人员", "跟踪人员", "微信号", "电话", "备注"};
            Label label = null;
            //迭代表头
            for (int i = 0; i < header.length; i++) {
                label = new Label(i, 0, header[i]);
                sheet.addCell(label);
            }

            //迭代数据
            for (int j = 1; j < list.size() + 1; j++) {
                label = new Label(0, j, String.valueOf(list.get(j - 1).getId()));
                //添加到页签中
                sheet.addCell(label);
                label = new Label(1, j, list.get(j - 1).getName());
                sheet.addCell(label);
                label = new Label(2, j, list.get(j - 1).getSaleMan().getRealname());
                sheet.addCell(label);
                label = new Label(3, j, String.valueOf(list.get(j - 1).getInputMan().getRealname()));
                sheet.addCell(label);
                label = new Label(4, j, String.valueOf(list.get(j - 1).getWeChatNum()));
                sheet.addCell(label);
                label = new Label(5, j, String.valueOf(list.get(j - 1).getTel()));
                sheet.addCell(label);
                sdf = new SimpleDateFormat("yyyy年MM月dd日");
                label = new Label(6, j, sdf.format(list.get(j - 1).getRemark()));
                sheet.addCell(label);
            }

            //写出数据
            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
