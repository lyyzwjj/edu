package cn.wolfcode.edu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@ToString
public class StudentLeave {
    private Long id;

    //流失学员
    private Client client;

    //流失班级
    private Grade grade;

    //流失阶段
    private int phase;

    //流失原因
    private String reason;

    //流失天数
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date leavetime;

    //经办人
    private Employee operator;

    //录入人
    private Employee inputer;

    //营销人员
    private Employee marketer;

    //是否退款
    private int reimburse;

    //审核状态
    private int state;

    //流失天数
    private Integer day;

    //审核人
    private Employee auditor;

}