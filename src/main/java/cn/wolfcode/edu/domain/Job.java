package cn.wolfcode.edu.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Job {

    private Long id;
    //基本工资
    private Long baseSalary;
    //公积金
    private Long accumulationFund;
    //社保
    private Long socialInsurance;
    //加班津贴
    private Long overtimeAllowance;
    //奖金
    private Long bonus;
    //奖金系数
    private Long coefficient;

}