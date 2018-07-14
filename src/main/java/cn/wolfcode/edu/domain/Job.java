package cn.wolfcode.edu.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class Job {

    private Long id;
    //基本工资
    private BigDecimal baseSalary;
    //公积金
    private BigDecimal accumulationFund;
    //社保
    private BigDecimal socialInsurance;
    //加班津贴
    private BigDecimal overtimeAllowance;
    //奖金
    private BigDecimal bonus;
    //奖金系数
    private BigDecimal coefficient;
    //职务
    private String jobName;
    //公积金缴存基数
    private BigDecimal proportion;

}