package cn.wolfcode.edu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 招聘计划对象
 */
@Setter
@Getter
public class Recruit {
    //编号
    private Long id;
    //招聘计划名称
    private String plan;
    //制定时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date draftTime;
    //状态(0表示未审核,1表示已审核)
    private Integer examineState = 0;
    //数据字典,招聘计划类别
    private DataDictionaryItem planType;
    //数据录入人
    private Employee inputUser;
    //数据审核人
    private Employee auditor;
    //审核时间
    private Date auditTime;

    private List<RecruitItem> items = new ArrayList<>();

}