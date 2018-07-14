package cn.wolfcode.edu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class Salary {

    private Long id;
    //工作天数
    private Integer workDay;
    //银行卡号
    private Long bankcardNumber;
    //迟到天数
    private Integer lateday;
    //实发工资
    private BigDecimal realWages;
    //对应的员工
    private Employee employee;
    //月份
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM")
    private Date month;

    public Integer getWorkDay() {
        return 30 - lateday;
    }

}