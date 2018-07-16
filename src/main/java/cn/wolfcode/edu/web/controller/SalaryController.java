package cn.wolfcode.edu.web.controller;

import cn.wolfcode.edu.domain.Job;
import cn.wolfcode.edu.domain.Salary;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;
import cn.wolfcode.edu.service.ISalaryService;
import cn.wolfcode.edu.util.JsonDataResult;
import cn.wolfcode.edu.util.JsonResult;
import cn.wolfcode.edu.util.PermissionName;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("salary")
public class SalaryController {
    @Autowired
    private ISalaryService salaryService;

    @RequestMapping("")
    @RequiresPermissions("salary:index")
    @PermissionName("工资首页")
    public String index() {

        return "salary/list";
    }

    @RequestMapping("list")
    @ResponseBody
    @RequiresPermissions("salary:list")
    @PermissionName("工资数据")
    public PageResult list(QueryObject qo) {
        PageResult result = salaryService.query(qo);
        List<Salary> rows = (List<Salary>) result.getRows();
        for (Salary row : rows) {
            Job job = row.getEmployee().getJob();
            BigDecimal baseSalary = job.getBaseSalary();//基本工资
            BigDecimal accumulationFund = job.getAccumulationFund();//公积金缴存基数
            BigDecimal proportion = job.getProportion();//比例
            BigDecimal bonus = job.getBonus();//奖金
            BigDecimal coefficient = job.getCoefficient();//奖金系数
            BigDecimal socialInsurance = job.getSocialInsurance();//社保
            BigDecimal overtimeAllowance = job.getOvertimeAllowance();//加班补贴
            BigDecimal salary = baseSalary.subtract(accumulationFund.multiply(proportion)).subtract(socialInsurance).add(bonus.multiply(coefficient)).add(overtimeAllowance);
            row.setRealWages(salary);
            salaryService.updateByPrimaryKey(row);
        }
        return result;
    }


    @RequestMapping("selectAll")
    @ResponseBody
    public List<Salary> selectAll() {
        List<Salary> salarys = salaryService.selectAll();
        return salarys;
    }

    @RequestMapping("queryByIdentifier")
    @ResponseBody
    public JsonResult queryByIdentifier(Long id) {
        JsonDataResult dataResult = new JsonDataResult();
        Salary salary = salaryService.queryByIdentifier(id);
        Date month = salary.getMonth();
        try {
            if (month != null) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                format.format(month);
            }
            dataResult.setJsonData(JSON.toJSONString(salary));
        } catch (Exception e) {
            e.printStackTrace();
            dataResult.markMsg("保存失败");
        }
        return dataResult;
    }


    @RequestMapping("/save")
    @ResponseBody
    public JsonResult save(Salary record) {
        JsonResult result = new JsonResult();
        try {
            salaryService.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("保存失败");
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(Salary salary) {
        JsonResult result = new JsonResult();
        try {
            salaryService.updateByPrimaryKey(salary);
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
            salaryService.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            result.markMsg("删除失败");
        }
        return result;
    }
}
